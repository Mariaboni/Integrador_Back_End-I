package com.dh.clinicaOdontologica;

import com.dh.clinicaOdontologica.dto.PacienteDTO;
import com.dh.clinicaOdontologica.dto.request.DentistaRequestDTO;
import com.dh.clinicaOdontologica.entity.Dentista;
import com.dh.clinicaOdontologica.entity.Paciente;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


@SpringBootTest
@AutoConfigureMockMvc(addFilters = false)
class ClinicaOdontologicaApplicationTests {

	@Autowired
	private MockMvc mockMvc;



	@Test
	@DisplayName("Deve retornar 404")
	void buscarDentistasPorMatricula_notFound() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/dentista/{matricula}", "34"))
				.andDo(MockMvcResultHandlers.print())
				.andExpect(MockMvcResultMatchers.status().isNotFound());
	}

	@Test
	@DisplayName("Deve cadastrar um dentista com sucesso")
	void cadastrarDentista() throws Exception {
		var dentista = new DentistaRequestDTO("Nome", 123456789);

		ObjectMapper mapper = new ObjectMapper();

		mockMvc.perform(MockMvcRequestBuilders.post("/dentista")
						.contentType(MediaType.APPLICATION_JSON)
						.content(mapper.writeValueAsString(dentista)))
				.andDo(MockMvcResultHandlers.print())
				.andExpect(MockMvcResultMatchers.status().isCreated());
	}


}
