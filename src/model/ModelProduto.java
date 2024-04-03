package model;

/**
 *
 * @author Vinicius
 */
public class ModelProduto {

    private int proId;
    private String proDescricao;
    private int proQuantidade;
    private double proValor;
    private String proDataCad;
    private int proRestante;
    private String proResponsavel;
    private String proDataSaida;
    private int proQuantidadeSaida;
    

    /**
     * @return the proId
     */
    public int getProId() {
        return proId;
    }

    /**
     * @param proId the proId to set
     */
    public void setProId(int proId) {
        this.proId = proId;
    }

    /**
     * @return the proDescricao
     */
    public String getProDescricao() {
        return proDescricao;
    }

    /**
     * @param proDescricao the proDescricao to set
     */
    public void setProDescricao(String proDescricao) {
        this.proDescricao = proDescricao;
    }

    /**
     * @return the proQuantidade
     */
    public int getProQuantidade() {
        return proQuantidade;
    }

    /**
     * @param proQuantidade the proQuantidade to set
     */
    public void setProQuantidade(int proQuantidade) {
        this.proQuantidade = proQuantidade;
    }

    /**
     * @return the proValor
     */
    public double getProValor() {
        return proValor;
    }

    /**
     * @param proValor the proValor to set
     */
    public void setProValor(double proValor) {
        this.proValor = proValor;
    }

    /**
     * @return the proDataCad
     */
    public String getProDataCad() {
        return proDataCad;
    }

    /**
     * @param proDataCad the proDataCad to set
     */
    public void setProDataCad(String proDataCad) {
        this.proDataCad = proDataCad;
    }

    /**
     * @return the proRestante
     */
    public int getProRestante() {
        return proRestante;
    }
    
    public void setProRestante(int proRestante){
        this.proRestante = proRestante;
    }

    /**
     * @return the proResponsavel
     */
    public String getProResponsavel() {
        return proResponsavel;
    }
    public void setProResponsavel(String proResponsavel){
        this.proResponsavel = proResponsavel;
    }

    /**
     * @return the proDataSaida
     */
    public String getProDataSaida() {
        return proDataSaida;
    }
    public void setProDataSaida(String proDataSaida){
        this.proDataSaida = proDataSaida;
}

    /**
     * @return the proQuantidadeSaida
     */
    public int getProQuantidadeSaida() {
        return proQuantidadeSaida;
    }
    
    public void setProQuantidadeSaida(int proQuantidadeSaida){
      this.proQuantidadeSaida = proQuantidadeSaida;
    }

    

}
