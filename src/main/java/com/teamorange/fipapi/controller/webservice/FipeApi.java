package com.teamorange.fipapi.controller.webservice;

import com.teamorange.fipapi.domain.model.webmodel.TabelaFipe;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.HashMap;
import java.util.List;

@FeignClient(name = "fipeApi", url = "https://parallelum.com.br/fipe/api/v1/carros/")
public interface FipeApi {

    @GetMapping("marcas")
    List<TabelaFipe> findMarcas();

    @GetMapping("marcas/{idMarca}/modelos")
    HashMap<String, List<TabelaFipe>> findModelos(@PathVariable("idMarca") String idMarca);

    @GetMapping("marcas/{idMarca}/modelos/{idModelo}/anos")
    List<TabelaFipe> findTipoEAno(@PathVariable("idMarca") String idMarca,
                                  @PathVariable("idModelo") String idModelo);

    @GetMapping("marcas/{idMarca}/modelos/{idModelo}/anos/{ano}")
    HashMap<String, String> findVeiculoInfo(@PathVariable("idMarca") String idMarca,
                            @PathVariable("idModelo") String idModelo,
                            @PathVariable("ano") String ano);

}
