package com.corso.models;

public class Customer {

    private String name;
    private String pIva;

    public Customer(String name, String pIva) {
        this.name = name;
        this.pIva = pIva;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((pIva == null) ? 0 : pIva.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Customer other = (Customer) obj;
        if (pIva == null) {
            if (other.pIva != null)
                return false;
        } else if (!pIva.equals(other.pIva))
            return false;
        return true;
    }

    public String getName() {
        return this.name;
    }

    public String getPIva() {
        return this.pIva;
    }
}
