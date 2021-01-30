package com.warehouse_accounting.models.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
public class Position {
    private Long id;
    private String name;
    private String sortNumber;

    public Position(String name, String sortNumber) {
        this.name = name;
        this.sortNumber = sortNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Position position = (Position) o;

        if (!id.equals(position.id)) return false;
        if (!Objects.equals(name, position.name)) return false;
        return Objects.equals(sortNumber, position.sortNumber);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (sortNumber != null ? sortNumber.hashCode() : 0);
        return result;
    }
}
