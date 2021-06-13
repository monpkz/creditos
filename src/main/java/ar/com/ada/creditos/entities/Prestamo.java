package ar.com.ada.creditos.entities;

import java.math.*;
import java.util.*;

import javax.persistence.*;

@Entity
@Table(name = "prestamo")
public class Prestamo {
    @Id
    @Column(name = "prestamo_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int prestamoId;

    @Temporal(TemporalType.DATE)
    @Column (name = "fecha_prestamo")
    private Date fecha;

    private BigDecimal importe;

    private int coutas;
    
    @Column(name = "fecha_alta")
    private Date fechaAlta;

    @ManyToOne // De muchos a uno
    @JoinColumn(name = "cliente_id", referencedColumnName = "cliente_id")
    // JoinColumns van donde esta la FK
    private Cliente cliente;

    public int getPrestamoId() {
        return prestamoId;
    }

    public void setPrestamoId(int prestamoId) {
        this.prestamoId = prestamoId;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public BigDecimal getImporte() {
        return importe;
    }

    public void setImporte(BigDecimal importe) {
        this.importe = importe;
    }

    public int getCoutas() {
        return coutas;
    }

    public void setCoutas(int coutas) {
        this.coutas = coutas;
    }

    public Date getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
        this.cliente.agregarPrestamo(this);
        //this.cliente.getPrestamo().add(this);relacion bidireccional
    }

}
