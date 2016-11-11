package br.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.primefaces.event.SelectEvent;

import br.AtendimentoLugares.Bairro;
import br.AtendimentoLugares.BairroRN;
import br.AtendimentoLugares.Cidade;
import br.AtendimentoLugares.CidadeRN;
import br.Empresa.Empresa;
import br.Empresa.EmpresaDAO;
import br.Empresa.EmpresaRN;
import br.Empresa.Categoria.CategoriaENUM;
import br.Objeto.CategoriaObjeto;
import br.Objeto.Objeto;
import br.dao.ObjetoDAO;
import br.dao.ObjetoRN;

@ManagedBean(name = "autoCompleteController")
@ViewScoped
public class AutoCompleteController implements Serializable {

	private static final long serialVersionUID = 1L;
	private Cidade cidade;
	private Bairro bairro;
	private int idBairro;
	private List<Empresa> empresas;
	private List<Objeto> objetos;
	private CategoriaObjeto categoriaObjeto = new CategoriaObjeto();
	private int categoriaEmpresa;
	private String urlPedido;

	public String getUrlPedido() {
		return urlPedido;
	}

	public void setUrlPedido(String urlPedido) {
		this.urlPedido = urlPedido;
	}

	public int getIdBairro() {
		return idBairro;
	}

	public void setIdBairro(int idBairro) {
		this.idBairro = idBairro;
	}

	public int getCategoriaEmpresa() {
		return categoriaEmpresa;
	}

	public void setCategoriaEmpresa(int categoriaEmpresa) {
		this.categoriaEmpresa = categoriaEmpresa;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	private Empresa empresa;

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public List<Empresa> getEmpresas() {
		if (empresas == null) {
			empresas = new ArrayList<Empresa>();
		}
		return empresas;
	}

	public void setEmpresas(List<Empresa> empresas) {
		this.empresas = empresas;
	}

	public Bairro getBairro() {
		if (bairro == null) {
			bairro = new Bairro();
		}
		return bairro;
	}

	public void setBairro(Bairro bairro) {
		this.bairro = bairro;
	}

	public List<Bairro> completaBairro(String query) {

		BairroRN bairroRN = new BairroRN();

		return bairroRN.getByDescription(this.cidade.getIdCidade(), query);
	}

	public void handleSelectBairro(SelectEvent event) {
		bairro = (Bairro) event.getObject();
	}
	
	public List<Objeto> getObjetos() {
		if(objetos==null){
			objetos = new ArrayList<Objeto>();
			//atualizaSelecaoObjetos();
		}
		return objetos;
	}

	public void setObjetos(List<Objeto> objetos) {
		this.objetos = objetos;
	}

	public void atualizaSelecaoObjetos(){
		if(this.cidade != null){
			
			this.objetos.clear(); 
			ObjetoRN objetoRN = new ObjetoRN();
			this.objetos.addAll(objetoRN.listaObjetosPelaCidade(this.cidade, this.categoriaObjeto));
			
		}
	}
	public void atualizaSelecaoEmpresa() {

		if(this.cidade != null){
			this.objetos.clear();
			ObjetoRN objetoRN = new ObjetoRN();
			this.objetos.addAll(objetoRN.listaObjetosPelaCidade(this.cidade, this.categoriaObjeto));
			
		}

	}



}
