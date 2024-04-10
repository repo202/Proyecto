package proyecto;

class Cuentas {
    private int numero;
    private String tipoCuenta;
    private int noCuenta;

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getTipoCuenta() {
        return tipoCuenta;
    }

    public void setTipoCuenta(String tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

    public int getNoCuenta() {
        return noCuenta;
    }

    public void setNoCuenta(int noCuenta) {
        this.noCuenta = noCuenta;
    }

    

    public Cuentas(int numero, String tipoCuenta, int noCuenta) {
        this.numero = numero;
        this.tipoCuenta = tipoCuenta;
        this.noCuenta = noCuenta;
    }

    @Override
    public String toString() {
        return "Cuentas " + "tipoCuenta=" + tipoCuenta + ", noCuenta=" + noCuenta;
    }
    
    
}
