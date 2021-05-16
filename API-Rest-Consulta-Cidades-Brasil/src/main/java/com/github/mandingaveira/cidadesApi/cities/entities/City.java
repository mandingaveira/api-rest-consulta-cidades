package com.github.mandingaveira.cidadesApi.cities.entities;

import com.github.mandingaveira.cidadesApi.states.entities.State;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import org.springframework.data.geo.Point;

import javax.persistence.*;

@Getter
@AllArgsConstructor
@Entity(name = "Cities")
@Table(name = "cidade")
@TypeDefs(value = {
        @TypeDef(name = "point", typeClass = PointType.class),
        @TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
})
public class City {

    @Id
    private final Long id;

    @Column(name = "nome")
    private String name;

    private Integer uf;

    private Integer ibge;

    @Column(name = "lat_lon")
    private String geolocation;

    @ManyToOne
    @JoinColumn(name = "estado", columnDefinition = "jsonb")
    private State state;

    @Type(type = "point")
    @Column(name = "lat_lon", updatable = false, insertable = false)
    private Point location;
}
