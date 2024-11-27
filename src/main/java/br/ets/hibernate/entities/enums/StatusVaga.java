package br.ets.hibernate.entities.enums;

public enum StatusVaga {
    STATUS_OCUPADO("ocupado"),
    STATUS_LIVRE("livre");

    private String status;

    StatusVaga(String status){
        this.status = status;
    }

    // Verifica se o status inserido realmente existe, se existir ele é retornado, se não um erro é retornado
    public static StatusVaga fromString(String value) {
        for (StatusVaga statusVaga : StatusVaga.values()){
            if (statusVaga.name().equalsIgnoreCase(value)) {
                return statusVaga;
            }
        }
        throw new IllegalArgumentException("Status inválido!");
    }
}
