package com.isosadev.conversordemoneda.consultas;

public record Divisa(String base_code,
                     String target_code,
                     double conversion_rate,
                     double conversion_result) {
    public String toString() {
        return "("+ base_code + ") Equivale a "+conversion_result +"("+ target_code +"), con una tasa de conversión de "
                + conversion_rate;
    }
}
