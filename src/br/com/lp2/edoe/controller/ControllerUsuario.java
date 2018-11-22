package br.com.lp2.edoe.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import br.com.lp2.edoe.dao.ReceptoresDao;
import br.com.lp2.edoe.model.InvalidArgumentException;
import br.com.lp2.edoe.model.Usuario;
import br.com.lp2.edoe.model.UsuarioDoador;
import br.com.lp2.edoe.model.UsuarioReceptor;

/**
 * Classe responsavel pelo controle, manipulacao e armazenamento de Usuarios e suas especializacoes.
 *
 * @author Caio Fernandes Moreira - caio.moreira@ccc.ufcg.edu.br
 * @author Klaywert Danillo Ferreira De Souza - klaywert.souza@ccc.ufcg.edu.br
 * @author Mathias Abreu Trajano - mathias.trajano@ccc.ufcg.edu.br
 *
 */
public class ControllerUsuario {

	private LinkedHashMap<String,Usuario> usuarios;
	private ReceptoresDao arquivoReceptores;
	private ArrayList<String> descritores;
	
	/**
	 * Construtor responsavel pela construcao da instancia da classe, assim como da colecao de armazenamento dos 
	 * usuarios e o acesso aos arquivos de armazenamento.
	 * 
	 */
	public ControllerUsuario() {
		
		usuarios = new LinkedHashMap<>();
		arquivoReceptores = new ReceptoresDao();
	}
	
	/**
	 * Metodo responsavel pelo cadastro de Usuarios do tipo {@link UsuarioDoador} no sistema, ele recebe todos os parametros 
	 * necessarios para a criacao dos mesmos. O processo comeca verificando a validade dos dados recebidos, seguido pela verificao 
	 * da existencia de tal usuario no sistema e por fim armazena o mesmo na colecao.
	 * 
	 * @param id identificacao do usuario. CPF para pessoa fisica, CNPJ para demais.
	 * @param nome nome do usuario
	 * @param email email do usuario
	 * @param celular celular de contato do usuario
	 * @param classe tipo de usuario
	 * 
	 * @return Retorna a identificao do Usuario recem cadastrado.

	 * @throws RuntimeException Excecao gerada caso algum dos parametros passados sejam nulos ou vazios.
	 * @throws NullPointerException Excecao gerada caso o usuario ja se encontre cadastrado no sistema.
	 * @throws IllegalArgumentException Essa excecao eh gerada caso seja passada uma classe de usuario que nao conste no sistema.
	 * 
	 */
	public String adicionarDoador(String id, String nome, String email, String celular, String classe) throws InvalidArgumentException {
		
		if(id == null || id.trim().isEmpty())
			throw new InvalidArgumentException("id","do usuario");
		
		if(usuarios.containsKey(id)) {
			
			throw new RuntimeException("Usuario ja existente: " + id + ".");
		}
		else {
			
			if(nome == null || nome.trim().isEmpty())
				throw new InvalidArgumentException("nome");
			if(email == null || email.trim().isEmpty())
				throw new InvalidArgumentException("email");
			if(celular == null || celular.trim().isEmpty())
				throw new InvalidArgumentException("celular");
			if(classe == null || classe.trim().isEmpty())
				throw new InvalidArgumentException("classe");
			
			if(classe.equals("PESSOA_FISICA") || classe.equals("IGREJA") || classe.equals("ORGAO_PUBLICO_ESTADUAL") || classe.equals("ORGAO_PUBLICO_FEDERAL") || classe.equals("ONG") || classe.equals("ASSOCIACAO") || classe.equals("SOCIEDADE")) {
				
				usuarios.put(id, new UsuarioDoador(nome, email, celular, classe, id));
				return id;
			}
			
			throw new IllegalArgumentException("Entrada invalida: opcao de classe invalida.");
		}
	}
	
	private void adicionarReceptores(ArrayList<String> receptores) {
		
		for (String receptor : receptores) {
			
			String[] dados = receptor.split(",");
			usuarios.put(dados[0],new UsuarioReceptor(dados[1],dados[2],dados[3],dados[4],dados[0]));
		}
	}

	/**
	 * Metodo que busca pela identificacao se determinado Usuario esta cadastrado no sistema. O metodo verifica se o numero da 
	 * identificao eh valido antes de realizar a busca em si.
	 * 
	 * @param id identificacao do usuario
	 * 
	 * @return Retorna a representacao textual do {@link Usuario}.
	 * 
	 * @throws RuntimeException Excecao gerada caso o numero de identificacao recebido seja invalido.
	 * @throws NullPointerException Essa excecao eh gerada caso o usuario nao seja encontrado no sistema.
	 * 
	 */
	public String buscarUsuarioPorId(String id) {
		
		if(id == null || id.trim().isEmpty())
			throw new RuntimeException("Entrada invalida: id do usuario nao pode ser vazio ou nulo.");
		
		if(usuarios.containsKey(id)) {
			
			for (Usuario usuario : usuarios.values()) {
				
				if(usuario.getIdentificacao().equals(id))
					return usuario.toString();
			}
		}
		
		throw new NullPointerException("Usuario nao encontrado: " + id + ".");
	}

	/**
	 * @param nome
	 * @return
	 * @throws InvalidArgumentException 
	 */
	public String buscarUsuarioPorNome(String nome) throws InvalidArgumentException {
		
		if(nome == null || nome.trim().isEmpty())
			throw new InvalidArgumentException("nome");
		
		ArrayList<Usuario> usuariosPorNome = new ArrayList<>();
		String retorno = "";
		
		for(Usuario usuario : usuarios.values()) {
			
			if(usuario.getNome().equals(nome))
				usuariosPorNome.add(usuario);
		}
		
		if(usuariosPorNome.size() == 0)
			throw new NullPointerException("Usuario nao encontrado: " + nome + ".");
		
		retorno += usuariosPorNome.get(0).toString();
		
		for (int i = 1;i < usuariosPorNome.size(); i++) {
			retorno += " | " + usuariosPorNome.get(i).toString();
		}
		return retorno;
	}

	/**
	 * Metodo que le receptores a serem cadastrados no sistema a partir de arquivos externos que sejam fornecidos ao mesmo.
	 * 
	 * @param caminho caminho do arquivo a ser lido.
	 * 
	 */
	public void lerReceptores(String caminho) {
		
		ArrayList<String> receptores = arquivoReceptores.lerReceptores(caminho);
		adicionarReceptores(receptores);
		
	}

	
	/**
	 * Metodo que atualiza os dados de um usuario do sistema. Caso um dos parametros seja nulo
	 * ou vazio, o dado correspondente nao eh editado. O metodo verifica se o numero da 
	 * identificacao eh valido antes de realizar a remocao.
	 * 
	 * @param id identificacao do usuario. CPF para pessoa fisica, CNPJ para demais.
	 * @param nome nome do usuario
	 * @param email email do usuario
	 * @param celular celular de contato do usuario
	 * @return Retorna a nova representacao textual do {@link Usuario}.
	 * @throws InvalidArgumentException 
	 */
	public String atualizaUsuario(String id, String nome, String email, String celular) throws InvalidArgumentException {
		if (id == null || id.trim().isEmpty())
			throw new InvalidArgumentException("id","do usuario");

		if (!usuarios.containsKey(id)) {
			throw new NullPointerException("Usuario nao encontrado: " + id + ".");
		}
		
		if(nome != null && !(nome.trim().isEmpty()))
			usuarios.get(id).setNome(nome);
		if(email != null && !(email.trim().isEmpty()))
			usuarios.get(id).setEmail(email);
		if(celular != null && !(celular.trim().isEmpty()))
			usuarios.get(id).setCelular(celular);
		
		return usuarios.get(id).toString();
	}

	/**
	 * Metodo que remove um usuario do sistema. O metodo verifica se o numero da 
	 * identificacao eh valido antes de realizar a remocao.
	 * 
	 * @param id identificacao do usuario. CPF para pessoa fisica, CNPJ para demais.
	 * @throws InvalidArgumentException 
	 */
	public void removeUsuario(String id) throws InvalidArgumentException {
		if (id == null || id.trim().isEmpty())
			throw new InvalidArgumentException("id","do usuario");
		
		if (!usuarios.containsKey(id)) {
			throw new NullPointerException("Usuario nao encontrado: " + id + ".");
		}
		
		usuarios.remove(id);
	}

	/**
	 * Metodo que atualiza os usuarios receptores cadastrados no sistema, modificando-os atraves da leitura de outro arquivo 
	 * que contem os dados atualizados dos mesmos.
	 * 
	 * @param caminho caminho do arquivo que contem os dados atualizados.
	 * 
	 */
	public void atualizarReceptores(String caminho) {
		
		ArrayList<String> receptoresParaAtualizar = arquivoReceptores.lerReceptores(caminho);
		
		for (String receptor : receptoresParaAtualizar) {
			
			String[] dados = receptor.split(",");
			
			for (String key : usuarios.keySet()) {
				
				if(usuarios.get(key).getIdentificacao().equals(dados[0])) {
					
					usuarios.remove(key);
					usuarios.put(key,new UsuarioReceptor(dados[1],dados[2],dados[3],dados[4],dados[0]));
				}
			}
		}
		
	}

}
