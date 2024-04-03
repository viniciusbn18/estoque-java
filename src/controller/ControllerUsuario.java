package controller;

import DAO.DAOUsuario;
import java.util.List;
import model.ModelUsuario;

public class ControllerUsuario {

    DAOUsuario dAOUsuario = new DAOUsuario();

    /**
     * salvar um novo usuário do banco
     *
     * @param modelUsuario
     * @return boolean
     */
    public boolean salvarUsuarioController(ModelUsuario modelUsuario) {
        return this.dAOUsuario.salvarUsuarioDAO(modelUsuario);
    }

    /**
     * Listar usuários do banco
     *
     * @return List
     */
    public List<ModelUsuario> getListaUsuariosController() {
        return this.dAOUsuario.getListausuarioDAO();
    }

    public boolean excluirUsuarioController(int pCodigo) {
        return this.dAOUsuario.excluirUsuarioDAO(pCodigo);
    }

    public ModelUsuario getUsuarioController(int pCodigo) {
        return this.dAOUsuario.getUsuarioDAO(pCodigo);
    }

    public boolean validarUsuarioController(ModelUsuario modelUsuario) {
        return this.dAOUsuario.validarUsuarioDAO(modelUsuario);
    }

    public boolean atualizarUsuarioController(ModelUsuario modelUsuario) {
        return this.dAOUsuario.atualizarUsuarioDAO(modelUsuario);
    }

}
