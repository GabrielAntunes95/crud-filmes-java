/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author gabri
 */
public class usuarioDAO {
    
    Connection conn;
    PreparedStatement pstm;
    ResultSet rs;
    ArrayList<usuarioDTO> lista = new ArrayList<>();
    
    public void cadastrarFilme(usuarioDTO objUsuarioDTO){
        
        String sql = "INSERT INTO tb_filmes (nome,tipo,diretor) values (?,?,?)";
        
        conn = new ConexaoDAO().conectaBD();
        
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, objUsuarioDTO.getNome());
            pstm.setString(2, objUsuarioDTO.getTipo());
            pstm.setString(3, objUsuarioDTO.getDiretor());
            
            pstm.execute();
            pstm.close();
            JOptionPane.showMessageDialog(null, "Filme incluído com sucesso!");
            
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "usuarioDAO" + erro);
        }
    }
    private Statement st;
    public ArrayList<usuarioDTO> pesquisarFilme(){
        
        String sql = "SELECT * FROM tb_filmes";
        conn = new ConexaoDAO().conectaBD();
        try {
           pstm = conn.prepareStatement(sql);
           rs = pstm.executeQuery();
           
           while(rs.next()){
             usuarioDTO objUsuarioDTO = new usuarioDTO();
             objUsuarioDTO.setId(rs.getInt("codigo"));
             objUsuarioDTO.setNome(rs.getString("nome"));
             objUsuarioDTO.setTipo(rs.getString("tipo"));
             objUsuarioDTO.setDiretor(rs.getString("diretor"));
             
             lista.add(objUsuarioDTO);
           }
           
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "usuarioDAO Pesquisar" + erro);
        }
        return lista;
    }
    
    public void alterarFlmes(usuarioDTO objUsuarioDTO){
        
        String sql = "UPDATE tb_filmes SET nome = ?, tipo = ?, diretor = ? where codigo = ?";
      
         conn = new ConexaoDAO().conectaBD();
        
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, objUsuarioDTO.getNome());
            pstm.setString(2, objUsuarioDTO.getTipo());
            pstm.setString(3, objUsuarioDTO.getDiretor());
            pstm.setInt(4, objUsuarioDTO.getId());
            
            pstm.execute();
            pstm.close();
            JOptionPane.showMessageDialog(null, "Filme alterado com sucesso!");
            
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "usuarioDAO Alterar" + erro);
        }
    }
    
    public void excluirFilme(usuarioDTO objUsuarioDTO){
        String sql = "DELETE FROM tb_filmes where codigo = ?";
        
        conn = new ConexaoDAO().conectaBD();
        
        try {
            pstm = conn.prepareStatement(sql);
         
            pstm.setInt(1, objUsuarioDTO.getId());
            
            pstm.execute();
            pstm.close();
            JOptionPane.showMessageDialog(null, "Filme excluído!");
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "usuarioDAO Excluir" + erro);
        }
        
    }
    
}
