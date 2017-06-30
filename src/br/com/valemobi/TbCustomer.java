/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.valemobi;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mauri
 */
@Entity
@Table(name = "TB_CUSTOMER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbCustomer.findAll", query = "SELECT t FROM TbCustomer t")
    , @NamedQuery(name = "TbCustomer.findByIdCustomer", query = "SELECT t FROM TbCustomer t WHERE t.idCustomer = :idCustomer")
    , @NamedQuery(name = "TbCustomer.findByCpfCnpj", query = "SELECT t FROM TbCustomer t WHERE t.cpfCnpj = :cpfCnpj")
    , @NamedQuery(name = "TbCustomer.findByNmCustomer", query = "SELECT t FROM TbCustomer t WHERE t.nmCustomer = :nmCustomer")
    , @NamedQuery(name = "TbCustomer.findByIsActive", query = "SELECT t FROM TbCustomer t WHERE t.isActive = :isActive")
    , @NamedQuery(name = "TbCustomer.findByVlTotal", query = "SELECT t FROM TbCustomer t WHERE t.vlTotal = :vlTotal")})
public class TbCustomer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_CUSTOMER")
    private Integer idCustomer;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CPF_CNPJ")
    private int cpfCnpj;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "NM_CUSTOMER")
    private String nmCustomer;
    @Basic(optional = false)
    @NotNull
    @Column(name = "IS_ACTIVE")
    private Character isActive;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "VL_TOTAL")
    private Double vlTotal;

    public TbCustomer() {
    }

    public TbCustomer(Integer idCustomer) {
        this.idCustomer = idCustomer;
    }

    public TbCustomer(Integer idCustomer, int cpfCnpj, String nmCustomer, Character isActive) {
        this.idCustomer = idCustomer;
        this.cpfCnpj = cpfCnpj;
        this.nmCustomer = nmCustomer;
        this.isActive = isActive;
    }

    public Integer getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(Integer idCustomer) {
        this.idCustomer = idCustomer;
    }

    public int getCpfCnpj() {
        return cpfCnpj;
    }

    public void setCpfCnpj(int cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }

    public String getNmCustomer() {
        return nmCustomer;
    }

    public void setNmCustomer(String nmCustomer) {
        this.nmCustomer = nmCustomer;
    }

    public Character getIsActive() {
        return isActive;
    }

    public void setIsActive(Character isActive) {
        this.isActive = isActive;
    }

    public Double getVlTotal() {
        return vlTotal;
    }

    public void setVlTotal(Double vlTotal) {
        this.vlTotal = vlTotal;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCustomer != null ? idCustomer.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbCustomer)) {
            return false;
        }
        TbCustomer other = (TbCustomer) object;
        if ((this.idCustomer == null && other.idCustomer != null) || (this.idCustomer != null && !this.idCustomer.equals(other.idCustomer))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.valemobi.TbCustomer[ idCustomer=" + idCustomer + " ]";
    }
    
}
