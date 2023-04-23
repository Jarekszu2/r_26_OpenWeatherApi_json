package model;//
//coord
//        lon	19.4088
//        lat	54.1522
//weather
//    0
//        id	803
//        main	"Clouds"
//        description	"zachmurzenie umiarkowane"
//        icon	"04d"
//base	  "stations"
//main
//        temp	14.43
//        feels_like	13.99
//        temp_min	12.75
//        temp_max	14.43
//        pressure	1010
//        humidity	79
//        sea_level	1010
//        grnd_level	1010
//visibility	10000
//wind
//        speed	6.37
//        deg	97
//        gust	11.58
//clouds
//        all	82
//dt	1681491970
//sys
//        type	2
//        id	2007860
//        country	"PL"
//        sunrise	1681443861
//        sunset	1681494043
//timezone	7200
//id	  3099759
//name    "Elbląg"
//cod	  200

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class OpenWeatherApiResponse {

    private Coord coord;
    private Weather[] weather;
    private String base;
    private Maiinn main;
    private int visibility;
    private Wind wind;
    private Clouds clouds;
    private int dt;
    private Sys sys;
    private int timezone;
    private int id;
    private String name;
    private int cod;
}
