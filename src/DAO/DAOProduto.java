package DAO;

import model.ModelProduto;

import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import util.ConexaoSQLite;

/**
 *
 * @author Vinicius
 */
public class DAOProduto extends ConexaoSQLite {

    /**
     * grava Produto
     *
     * @param pModelProduto
     * @return int
     */
    public boolean salvarProdutoDAO(ModelProduto pModelProduto) {
        this.conectar();
        String sql
                = "INSERT INTO tbl_produto ("
                + "pro_descricao,"
                + "pro_quantidade,"
                + "pro_valor,"
                + "pro_dt_cadastro,"
                + "pro_dt_saida,"
                + "pro_qtd_saida,"
                + "pro_restante,"
                + "pro_responsavel"
                + ") VALUES (?,?,?,?,?,?,?,?);";
        try (PreparedStatement preparedStatement = criarPreparedStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, pModelProduto.getProDescricao());
            preparedStatement.setInt(2, pModelProduto.getProQuantidade());
            preparedStatement.setDouble(3, pModelProduto.getProValor());
            preparedStatement.setString(4, pModelProduto.getProDataCad());
            preparedStatement.setString(5, pModelProduto.getProDataSaida());
            preparedStatement.setInt(6, pModelProduto.getProQuantidadeSaida());
            preparedStatement.setInt(7, pModelProduto.getProRestante());
            preparedStatement.setString(8, pModelProduto.getProResponsavel());
            preparedStatement.executeUpdate();
        } catch (Exception e) {

            return false;
        } finally {
            this.desconectar();
            return true;
        }

    }

    /**
     * recupera Produto
     *
     * @param pProId
     * @return ModelProduto
     */
    public ModelProduto getProdutoDAO(int pProId) {
        ModelProduto modelProduto = null;

        String sql = "SELECT "
                + "pk_pro_id,"
                + "pro_descricao,"
                + "pro_quantidade,"
                + "pro_valor,"
                + "pro_dt_cadastro,"
                + "pro_dt_saida,"
                + "pro_qtd_saida,"
                + "pro_restante,"
                + "pro_responsavel"
                + " FROM"
                + " tbl_produto"
                + " WHERE"
                + " pk_pro_id = ?"
                + ";";

        this.conectar();

        try (PreparedStatement preparedStatement = criarPreparedStatement(sql)) {

            preparedStatement.setInt(1, pProId);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                modelProduto = new ModelProduto();
                modelProduto.setProId(resultSet.getInt(1));
                modelProduto.setProDescricao(resultSet.getString(2));
                modelProduto.setProQuantidade(resultSet.getInt(3));
                modelProduto.setProValor(resultSet.getDouble(4));
                modelProduto.setProDataCad(resultSet.getString(5));
                modelProduto.setProDataSaida(resultSet.getString(6));
                modelProduto.setProQuantidadeSaida(resultSet.getInt(7));
                modelProduto.setProRestante(resultSet.getInt(8));
                modelProduto.setProResponsavel(resultSet.getString(9));

            }
        } catch (Exception e) {
        } finally {
            this.desconectar();
        }
        return modelProduto;
    }

    /**
     * recupera uma lista de Produto
     *
     * @return ArrayList
     */
    public ArrayList<ModelProduto> getListaProdutoDAO() {
        ArrayList<ModelProduto> listamodelProduto = new ArrayList();
        ModelProduto modelProduto = null;

        String sql = "SELECT "
                + "pk_pro_id,"
                + "pro_descricao,"
                + "pro_quantidade,"
                + "pro_valor,"
                + "pro_dt_cadastro,"
                + "pro_dt_saida,"
                + "pro_qtd_saida,"
                + "pro_restante,"
                + "pro_responsavel"
                + " FROM"
                + " tbl_produto"
                + ";";

        this.conectar();

        try (PreparedStatement preparedStatement = criarPreparedStatement(sql)) {

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                modelProduto = new ModelProduto();
                modelProduto.setProId(resultSet.getInt(1));
                modelProduto.setProDescricao(resultSet.getString(2));
                modelProduto.setProQuantidade(resultSet.getInt(3));
                modelProduto.setProValor(resultSet.getDouble(4));
                modelProduto.setProDataCad(resultSet.getString(5));
                modelProduto.setProDataSaida(resultSet.getString(6));
                modelProduto.setProQuantidadeSaida(resultSet.getInt(7));
                modelProduto.setProRestante(resultSet.getInt(8));
                modelProduto.setProResponsavel(resultSet.getString(9));
                listamodelProduto.add(modelProduto);
            }
        } catch (Exception e) {
        } finally {
            this.desconectar();
        }
        return listamodelProduto;
    }

    /**
     * atualiza Produto
     *
     * @param pModelProduto
     * @return boolean
     */
    public boolean atualizarProdutoDAO(ModelProduto pModelProduto) {
        this.conectar();
        String sql
                = "UPDATE tbl_produto SET "
                + "pk_pro_id = ?,"
                + "pro_descricao = ?,"
                + "pro_quantidade = ?,"
                + "pro_valor = ?,"
                + "pro_dt_cadastro =?,"
                + "pro_dt_saida =?,"
                + "pro_qtd_saida=?,"
                + "pro_restante =?,"
                + "pro_responsavel =?"
                + " WHERE pk_pro_id = ? "
                + ";";

        try (PreparedStatement preparedStatement = criarPreparedStatement(sql)) {
            preparedStatement.setInt(1, pModelProduto.getProId());
            preparedStatement.setString(2, pModelProduto.getProDescricao());
            preparedStatement.setInt(3, pModelProduto.getProQuantidade());
            preparedStatement.setDouble(4, pModelProduto.getProValor());
            preparedStatement.setString(5, pModelProduto.getProDataCad());
            preparedStatement.setString(6, pModelProduto.getProDataSaida());
            preparedStatement.setInt(7, pModelProduto.getProQuantidadeSaida());
            preparedStatement.setInt(8, pModelProduto.getProRestante());
            preparedStatement.setString(9, pModelProduto.getProResponsavel());
            preparedStatement.setInt(10, pModelProduto.getProId());
            return preparedStatement.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            this.desconectar();
            //return true;
        }

    }

    /**
     * exclui Produto
     *
     * @param pProId
     * @return boolean
     */
    public boolean excluirProdutoDAO(int pProId) {
        this.conectar();
        String sql
                = "DELETE FROM tbl_produto "
                + " WHERE pk_pro_id = ? "
                + ";";

        try (PreparedStatement preparedStatement = criarPreparedStatement(sql)) {
            preparedStatement.setInt(1, pProId);
            return preparedStatement.executeUpdate() > 0;
        } catch (Exception e) {
            return false;
        } finally {
            this.desconectar();
        }

    }

    public ModelProduto getProdutoDescricaoDAO(String pProDescricao) {

        ModelProduto modelProduto = null;

        String sql = "SELECT "
                + "pk_pro_id,"
                + "pro_descricao,"
                + "pro_quantidade,"
                + "pro_valor,"
                + "pro_dt_cadastro,"
                + "pro_dt_saida,"
                + "pro_qtd_saida,"
                + "pro_restante,"
                + "pro_responsavel"
                + " FROM"
                + " tbl_produto "
                + " WHERE"
                + " pro_descricao = ?"
                + ";";

        this.conectar();
        try (PreparedStatement preparedStatement = criarPreparedStatement(sql)) {
            preparedStatement.setString(1, pProDescricao);
            ResultSet resultSet = preparedStatement.executeQuery();
            
            while (resultSet.next()) {

                modelProduto = new ModelProduto();
                modelProduto.setProId(resultSet.getInt(1));
                modelProduto.setProDescricao(resultSet.getString(2));
                modelProduto.setProQuantidade(resultSet.getInt(3));
                modelProduto.setProValor(resultSet.getDouble(4));
                modelProduto.setProDataCad(resultSet.getString(5));
                modelProduto.setProDataSaida(resultSet.getString(6));
                modelProduto.setProQuantidadeSaida(resultSet.getInt(7));
                modelProduto.setProResponsavel(resultSet.getString(8));
                modelProduto.setProRestante(resultSet.getInt(9));
            }

        } catch (Exception e) {
            
        } finally {
            this.desconectar();
        }
        return modelProduto;
    }
 public boolean atualizarEstoqueDAO(ModelProduto pModelProduto) {
        this.conectar();
        String sql
                = "UPDATE tbl_produto SET "
                + "pk_pro_id = ?,"
                + "pro_descricao = ?,"
                + "pro_quantidade = ?,"
                + "pro_valor = ?,"
                + "pro_dt_cadastro =?,"
                + "pro_dt_saida =?,"
                + "pro_qtd_saida=?,"
                + "pro_restante =?,"
                + "pro_responsavel =?"
                + " WHERE pk_pro_id = ? "
                + ";";

        try (PreparedStatement preparedStatement = criarPreparedStatement(sql)) {
            preparedStatement.setInt(1, pModelProduto.getProId());
            preparedStatement.setString(2, pModelProduto.getProDescricao());
            preparedStatement.setInt(3, pModelProduto.getProRestante());
            preparedStatement.setDouble(4, pModelProduto.getProRestante());
            preparedStatement.setString(5, pModelProduto.getProDataCad());
            preparedStatement.setString(6, pModelProduto.getProDataSaida());
            preparedStatement.setInt(7, pModelProduto.getProQuantidadeSaida());
            preparedStatement.setInt(8, pModelProduto.getProRestante());
            preparedStatement.setString(9, pModelProduto.getProResponsavel());
            preparedStatement.setInt(10, pModelProduto.getProId());
            return preparedStatement.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            this.desconectar();
        }

    }

}
