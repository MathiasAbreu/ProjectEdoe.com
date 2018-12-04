package br.com.lp2.edoe.dao;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.NoSuchElementException;

import br.com.lp2.edoe.model.Usuario;

/**
 *
 * @author Caio Fernandes Moreira - caio.moreira@ccc.ufcg.edu.br
 * @author Klaywert Danillo Ferreira De Souza - klaywert.souza@ccc.ufcg.edu.br
 * @author Mathias Abreu Trajano - mathias.trajano@ccc.ufcg.edu.br
 * 
 */
public class UsuariosDAO {

	private static ObjectOutputStream outputUsuario;
	private static ObjectInputStream inputUsuario;
	
	public UsuariosDAO() throws IOException {
				
	}
	
	public static ArrayList<Usuario> lerUsuarios(){
		
		ArrayList<Usuario> usuarios = new ArrayList<>();
		
		try {
			
			inputUsuario = new ObjectInputStream(Files.newInputStream(Paths.get("src/br/com/lp2/edoe/dao/Usuarios.ser")));
			
			while(true) {
				
				Usuario usuario = (Usuario) inputUsuario.readObject();
				usuarios.add(usuario);
			}
		
		} catch (IOException ioe) {
			
			return usuarios;
			
		} catch (ClassNotFoundException cnf) {
			
			throw new NullPointerException("Erro no arquivo 'Usuarios.ser'");
			
		}
	}
	
	public static void escreverUsuarios(Collection<Usuario> usuarios) {
		
		try {
			
			outputUsuario = new ObjectOutputStream(Files.newOutputStream(Paths.get("src/br/com/lp2/edoe/dao/Usuarios.ser")));

			for(Usuario usuario : usuarios) 
				outputUsuario.writeObject(usuario);
			
			outputUsuario.close();
		} catch (IOException ioe) {
			
			return;
		} catch (NoSuchElementException nse) {
			
			throw new RuntimeException("Erro ao escrever usuarios");
		}
	}
}
