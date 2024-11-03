package desafio3.devsuperior.dto;

import java.time.LocalDate;

public class ClientDto {

    private Long id;
    private String name;
    private String cpf;
    private Double income; //renda
    private LocalDate birthDate; //data de nascimento
    private Integer children; //quantidade de filhos

    public ClientDto() {
    }

    public ClientDto(Long id, String name, String cpf, Double income, LocalDate birthDate, Integer children) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.income = income;
        this.birthDate = birthDate;
        this.children = children;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCpf() {
        return cpf;
    }

    public Double getIncome() {
        return income;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public Integer getChildren() {
        return children;
    }
}
