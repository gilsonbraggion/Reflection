package br.com.reflection.modelo;

public class Pessoa {

	private String nome;

	private Integer idade;

	private Boolean ativo;

	private Double saldo;
	
	private boolean campoPrimitivo;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}
	
	public boolean isCampoPrimitivo() {
		return campoPrimitivo;
	}

	public void setCampoPrimitivo(boolean campoPrimitivo) {
		this.campoPrimitivo = campoPrimitivo;
	}

	@Override
	public String toString() {
		return "Pessoa [nome=" + nome + ", idade=" + idade + ", ativo=" + ativo + ", saldo=" + saldo +" ] ";
	}

}
