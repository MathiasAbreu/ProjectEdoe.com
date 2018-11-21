package br.com.lp2.edoe.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import br.com.lp2.edoe.dao.ReceptoresDao;
import br.com.lp2.edoe.model.Usuario;
import br.com.lp2.edoe.model.UsuarioDoador;
import br.com.lp2.edoe.model.UsuarioReceptor;

/**
 * Classe responsável pelo controle, manipulação e armazenamento de Usuarios e suas especializações.
 *
 * @author Caio Fernandes Moreira - caio.moreira@ccc.ufcg.edu.br
 * @author Klaywert Danillo Ferreira De Souza - klaywert.souza@ccc.ufcg.edu.br
 * @author Mathias Abreu Trajano - mathias.trajano@ccc.ufcg.edu.br
 *
 */
public class ControllerUsuario {

	private List<Usuario> usuarios;
	private ReceptoresDao arquivoReceptores;
	
	/**
	 * Construtor responsável pela construção da instância da classe, assim como da coleção de armazenamento dos 
	 * usuários e o acesso aos arquivos de armazenamento.
	 * 
	 */
	public ControllerUsuario() {
		
		usuarios = new ArrayList<>();
		arquivoReceptores = new ReceptoresDao();
	}
	
	private boolean contemUsuario(String id) {
		
		for (Usuario usuario : usuarios) {
			
			if(usuario.getIdentificacao().equals(id))
				return true;
		}
		
		return false;
	}
	
	/**
	 * Método responsável pelo cadastro de Usuários do tipo {@link UsuarioDoador} no sistema, ele recebe todos os parâmetros 
	 * necessários para a criação dos mesmos. O processo começa verificando a validade dos dados recebidos, seguido pela verificação 
	 * da existência de tal usuário no sistema e por fim armazena o mesmo na coleção.
	 * 
	 * @param id identificação do usuário. CPF para pessoa física, CNPJ para demais.
	 * @param nome nome do usuário
	 * @param email email do usuário
	 * @param celular celular de contato do usuário
	 * @param classe tipo de usuário
	 * 
	 * @return Retorna a identificação do Usuário recém cadastrado.
	 * 
	 * @throws RuntimeException Exceção gerada caso algum dos parâmetros passados sejam nulos ou vazios.
	 * @throws NullPointerException Exceção gerada caso o usuário já se encontre cadastrado no sistema.
	 * @throws IllegalArgumentException Essa exceção é gerada caso seja passada uma classe de usuário que não conste no sistema.
	 * 
	 */
	public String adicionarDoador(String id, String nome, String email, String celular, String classe) {
		
		if(id == null || id.trim().isEmpty())
			throw new RuntimeException("Entrada invalida: id do usuario nao pode ser vazio ou nulo.");
		
		if(contemUsuario(id)) {
			
			throw new NullPointerException("Usuario ja existente: " + id + ".");
		}
		else {
			
			if(nome == null || nome.trim().isEmpty())
				throw new RuntimeException("Entrada invalida: nome nao pode ser vazio ou nulo.");
			if(email == null || email.trim().isEmpty())
				throw new RuntimeException("Entrada invalida: email nao pode ser vazio ou nulo.");
			if(celular == null || celular.trim().isEmpty())
				throw new RuntimeException("Entrada invalida: celular nao pode ser vazio ou nulo.");
			if(classe == null || classe.trim().isEmpty())
				throw new RuntimeException("Entrada invalida: classe nao pode ser vazia ou nula.");
			
			if(classe.equals("PESSOA_FISICA") || classe.equals("IGREJA") || classe.equals("ORGAO_PUBLICO_ESTADUAL") || classe.equals("ORGAO_PUBLICO_FEDERAL") || classe.equals("ONG") || classe.equals("ASSOCIACAO") || classe.equals("SOCIEDADE")) {
				
				usuarios.add(new UsuarioDoador(nome, email, celular, classe, id));
				return id;
			}
			
			throw new IllegalArgumentException("Entrada invalida: opcao de classe invalida.");
		}
	}
	
	private void adicionarReceptores(ArrayList<String> receptores) {
		
		for (String receptor : receptores) {
			
			String[] dados = receptor.split(",");
			usuarios.add(new UsuarioReceptor(dados[1],dados[2],dados[3],dados[4],dados[0]));
		}
	}

	/**
	 * Método que busca pela identificação se determinado Usuário está cadastrado no sistema. O método verifica se o numero da 
	 * identificação é válido antes de realizar a busca em si.
	 * 
	 * @param id identificação do usuário
	 * 
	 * @return Retorna a representação textual do {@link Usuario}.
	 * 
	 * @throws RuntimeException Exceção gerada caso o número de identificação recebido seja inválido.
	 * @throws NullPointerException Essa exceção é gerada caso o usuário não seja encontrado no sistema.
	 * 
	 */
	public String buscarUsuarioPorId(String id) {
		
		if(id == null || id.trim().isEmpty())
			throw new RuntimeException("Entrada invalida: id do usuario nao pode ser vazio ou nulo.");
		
		if(contemUsuario(id)) {
			
			for (Usuario usuario : usuarios) {
				
				if(usuario.getIdentificacao().equals(id))
					return usuario.toString();
			}
		}
		
		throw new NullPointerException("Usuario nao encontrado: " + id + ".");
	}

	/**
	 * @param nome
	 * @return
	 */
	public String buscarUsuarioPorNome(String nome) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Método que lê receptores a serem cadastrados no sistema a partir de arquivos externos que sejam fornecidos ao mesmo.
	 * 
	 * @param caminho caminho do arquivo a ser lido.
	 * 
	 */
	public void lerReceptores(String caminho) {
		
		ArrayList<String> receptores = arquivoReceptores.lerReceptores(caminho);
		adicionarReceptores(receptores);
		
	}

	/**
	 * @param id
	 * @param nome
	 * @param email
	 * @param celular
	 * @return
	 */
	public void atualizaUsuario(String id, String nome, String email, String celular) {
		// TODO Auto-generated method stub
	}

	/**
	 * @param id
	 */
	public void removeUsuario(String id) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Método que atualiza os usuários receptores cadastrados no sistema, modificando-os atraves da leitura de outro arquivo 
	 * que contém os dados atualizados dos mesmos.
	 * 
	 * @param caminho caminho do arquivo que contém os dados atualizados.
	 * 
	 */
	public void atualizarReceptores(String caminho) {
		
		ArrayList<String> receptoresParaAtualizar = arquivoReceptores.lerReceptores(caminho);
		
		for (String receptor : receptoresParaAtualizar) {
			
			String[] dados = receptor.split(",");
			
			for (int i = 0; i < usuarios.size(); i++) {
				
				if(usuarios.get(i).getIdentificacao().equals(dados[0])) {
					
					usuarios.remove(i);
					usuarios.add(i,new UsuarioReceptor(dados[1],dados[2],dados[3],dados[4],dados[0]));
				}
			}
		}
		
	}

}
