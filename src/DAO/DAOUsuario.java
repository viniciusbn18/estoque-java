package DAO;

import java.util.List;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.ModelUsuario;
import util.ConexaoSQLite;
import java.sql.ResultSet;

/**
 *
 * @author VBN
 */
public class DAOUsuario extends ConexaoSQLite {

    /**
     * Salva um novo usuário no banco de dados.
     *
     * @author CGFEGF
     * @param pModelUsuario
     * @return 
     */
    public boolean salvarUsuarioDAO(ModelUsuario pModelUsuario) {
        conectar();
        //excutar sql
        String sql = "INSERT INTO tbl_usuario("
                + "usu_nome, "
                + "usu_login, "
                + "usu_senha) "
                + "VALUES (?,?,?)";
        PreparedStatement preparedStatement = criarPreparedStatement(sql, Statement.RETURN_GENERATED_KEYS);
        try {
            preparedStatement.setString(1, pModelUsuario.getUsuNome());
            preparedStatement.setString(2, pModelUsuario.getUsuLogin());
            preparedStatement.setString(3, pModelUsuario.getUsuSenha());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOUsuario.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        desconectar();
        return true;

    }

    /**
     *
     * @return
     */
    public List<ModelUsuario> getListausuarioDAO() {
        List<ModelUsuario> listaUsuarios = new ArrayList<>();//cria lista de usuário vazia
        ModelUsuario modelUsuario = new ModelUsuario();//objeto usuário para armazenar o usuário temporariamente até salvar na lista
        conectar();
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;

        String sql = "SELECT pk_usu_id, "
                + "usu_nome, "
                + "usu_login, "
                + "usu_senha "
                + " FROM tbl_usuario";

        try {
            preparedStatement = criarPreparedStatement(sql);//representa a instrução que será usada, ou seja, o SQL e invocado através do objeto Connection.
            resultSet = preparedStatement.executeQuery();//serve para percorrer uma tabela de dados em um banco de dados.
            while (resultSet.next()) {// enquanto houver registro no banco
                modelUsuario = new ModelUsuario();//apagar tudo no objeto usuário
                modelUsuario.setUsuId(resultSet.getInt(1));//preencher cada dado do objeto usuário como segue a lista
                modelUsuario.setUsuNome(resultSet.getString(2));
                modelUsuario.setUsuLogin(resultSet.getString(3));
                modelUsuario.setUsuSenha(resultSet.getString(4));
                listaUsuarios.add(modelUsuario);//enviar para a lista de objetos modelUsuario.

            }
        } catch (Exception e) {
            System.err.println(e);//imprimir o erro
        }
        desconectar();//desconecta do banco
        return listaUsuarios;//retorna lista
    }

    /**
     * Excluir usuário a partir do Id.
     *
     * @param pCodigo
     * @return boolean
     */
    public boolean excluirUsuarioDAO(int pCodigo) {
        conectar();
        PreparedStatement preparedStatement; //vazio não recebe nada pois vai deletar um registro

        String sql = " DELETE FROM tbl_usuario "
                + " WHERE pk_usu_id = '" + pCodigo + "'";
        preparedStatement = this.criarPreparedStatement(sql); //preparar o banco para altreração receber o SQL.
        try {
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOUsuario.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();//imprimir o erro no console
            return false;
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();//imprimir o erro no console
                    Logger.getLogger(DAOUsuario.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        this.desconectar();
        return true;
    }

    public ModelUsuario getUsuarioDAO(int pCodigoUsuario) {
        ModelUsuario modelUsuario = new ModelUsuario();
        conectar();
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;

        String sql = "SELECT pk_usu_id, "
                + "usu_nome, "
                + "usu_login, "
                + "usu_senha "
                + " FROM tbl_usuario WHERE pk_usu_id = '" + pCodigoUsuario + "'";
        preparedStatement = criarPreparedStatement(sql);

        try {
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                modelUsuario = new ModelUsuario();
                modelUsuario.setUsuId(resultSet.getInt("pk_usu_id"));
                modelUsuario.setUsuNome(resultSet.getString("usu_nome"));
                modelUsuario.setUsuLogin(resultSet.getString("usu_login"));
                modelUsuario.setUsuSenha(resultSet.getString("usu_senha"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOUsuario.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception e) {
            System.err.println(e);//imprimir o erro
        }
        desconectar();
        return modelUsuario;

    }

    public boolean atualizarUsuarioDAO(ModelUsuario modelUsuario) {
        this.conectar();
        String sql = ("UPDATE tbl_usuario set "
                + "usu_nome =?,"
                + " usu_login =?,"
                + " usu_senha =?"
                + " WHERE pk_usu_id = '" + modelUsuario.getUsuId() + "'");
        PreparedStatement preparedStatement = criarPreparedStatement(sql);
        try {
            preparedStatement.setString(1, modelUsuario.getUsuNome());
            preparedStatement.setString(2, modelUsuario.getUsuLogin());
            preparedStatement.setString(3, modelUsuario.getUsuSenha());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOUsuario.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    Logger.getLogger(DAOUsuario.class.getName()).log(Level.SEVERE, null, ex);
                    return false;
                }
            }
        }

        this.desconectar();
        return true;

    }

    public boolean validarUsuarioDAO(ModelUsuario modelUsuario) {
        conectar();
        ResultSet resultset = null;
        PreparedStatement preparedStatement = null;
        String sql = "SELECT pk_usu_id, "
                + "usu_nome, "
                + "usu_login, "
                + "usu_senha "
                + " FROM tbl_usuario "
                + "WHERE usu_login = '" + modelUsuario.getUsuLogin() + "' AND "
                + " usu_senha = '" + modelUsuario.getUsuSenha() + "'";

        preparedStatement = criarPreparedStatement(sql);
        try {
            resultset = preparedStatement.executeQuery();
            if (resultset.next()) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;

        } finally {
            if (preparedStatement != null) {
                try {
                    resultset.close();
                    preparedStatement.close();
                    desconectar();
                } catch (SQLException ex) {

                    ex.printStackTrace();
                }

            }
        }

    }
}
