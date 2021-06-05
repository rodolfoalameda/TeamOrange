package com.teamorange.fipapi.services;

import com.teamorange.fipapi.controller.webservice.FipeApi;
import com.teamorange.fipapi.domain.Veiculo;
import com.teamorange.fipapi.domain.model.VeiculoDTO;
import com.teamorange.fipapi.domain.model.webmodel.TabelaFipe;
import com.teamorange.fipapi.repositories.VeiculoRepository;
import com.teamorange.fipapi.utils.mappers.VeiculoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Calendar;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@Transactional
public class VeiculoService {

    @Autowired
    private VeiculoRepository veiculoRepository;

    @Autowired
    private VeiculoMapper veiculoMapper;

    @Autowired
    private FipeApi fipeApi;

    public VeiculoDTO insert(VeiculoDTO veiculoDTO) {

        Veiculo veiculo = veiculoMapper.frommDtoToEntity(veiculoDTO);
        veiculo.setDiaDoRodizio(diaRodizio(veiculo.getAno()));
        veiculo.setValor(getInfoVeiculo(veiculoDTO));

        if(Objects.nonNull(veiculoDTO) && verificaRodizio().equals(veiculo.getDiaDoRodizio())){
          veiculo.setRodizioAtivo(true);
        } else {
            veiculo.setRodizioAtivo(false);
        }

        Veiculo veiculoPers = veiculoRepository.save(veiculo);
        return veiculoMapper.fromEntityToDto(veiculoPers);
    }

    public String diaRodizio(String anoVeiculo) {
        Character parametro = anoVeiculo.charAt(anoVeiculo.length() - 1);

        switch (parametro) {
            case '0':
            case '1':
                return "Segunda";
            case '2':
            case '3':
                return "Terça";
            case '4':
            case '5':
                return "Quarta";
            case '6':
            case '7':
                return "Quinta";
            case '8':
            case '9':
                return "Sexta";
        }
        return null;
    }

    public String getInfoVeiculo(VeiculoDTO veiculoDTO) {
        TabelaFipe marcaVeiculo = fipeApi.findMarcas().stream().filter(
                tabelaFipeModel -> tabelaFipeModel.getNome().equals(veiculoDTO.getMarca())).collect(Collectors.toList()).get(0);

        TabelaFipe modeloVeiculo = fipeApi.findModelos(marcaVeiculo.getCodigo()).get("modelos").stream().filter(
                tabelaFipeModel -> tabelaFipeModel.getNome().equals(veiculoDTO.getModelo())).collect(Collectors.toList()).get(0);

        TabelaFipe anoVeiculo = fipeApi.findTipoEAno(marcaVeiculo.getCodigo(), modeloVeiculo.getCodigo()).stream().filter(
                tabelaFipeModel -> tabelaFipeModel.getNome().equals(veiculoDTO.getAnoTipo())).collect(Collectors.toList()).get(0);

        return fipeApi.findVeiculoInfo(marcaVeiculo.getCodigo(), modeloVeiculo.getCodigo(), anoVeiculo.getCodigo()).get("Valor");

    }

    public String verificaRodizio() {
        Calendar calendar = Calendar.getInstance();
        int dia = calendar.get(Calendar.DAY_OF_WEEK);

        switch (dia) {
            case 1 :
                return "Segunda";
            case 2 :
                return "Terça";
            case 3 :
                return "Quarta";
            case 4 :
                return "Quinta";
            case 5 :
                return "Sexta";
            case 6 :
                return "Sabado";
            case 7 :
                return "Domingo";
        }
        return null;
    }
}
