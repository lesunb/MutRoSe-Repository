package br.unb.cic.integration;

import static org.junit.jupiter.api.Assertions.assertThrows;
//import static io.restassured.module.mockmvc.RestAssuredMockMvc.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import br.unb.cic.modelling.models.MutRoSe;

@WebAppConfiguration
@SuppressWarnings("unused")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { Application.class })
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MutRoSeIntegrationTest {

	private MockMvc mockMvc;

	@Autowired
	private IntegrationService service;

	@Autowired
	private IntegrationController controller;

	@Autowired
	private WebApplicationContext webApplicationContext;

	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	private String getContent(String path) throws IOException {
		return new String(Files.readAllBytes(Paths.get("src/main/resources/testFiles/MutRoSe/" + path)));
	}

	@Test
	public void Teste3() throws Exception {
		try {
			mockMvc.perform(get("/load/terminal")).andDo(print()).andDo(print()).andExpect(status().isOk()).andReturn();
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}

	@Test
	public void test4() throws Exception {
		String model = getContent("model.txt");
		String configJson = getContent("configFile.json");
		String configHddl = getContent("configHddl.hddl");
		String world = getContent("worldKnowledge.xml");

		MutRoSe content = new MutRoSe(model, configHddl, configJson, world);
		try {
			Assert.assertTrue(true);
//			String result = service.generateBinMultRoSe(content);
//			Assert.assertTrue(!result.isEmpty());
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	@Test
	public void test5() throws Exception {
		String model = getContent("model2.txt");
		String configJson = getContent("configFile2.json");
		String configHddl = getContent("configHddl.hddl");
		String world = getContent("worldKnowledge.xml");

		MutRoSe content = new MutRoSe(model, configHddl, configJson, world);
		try {
			Assert.assertTrue(true);
//			String result = service.generateBinMultRoSe(content);
//			Assert.assertTrue(!result.isEmpty());
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	@Test
	public void test6() throws Exception {
		String model = getContent("model3.txt");
		String configJson = getContent("configFile3.json");
		String configHddl = getContent("configHddl.hddl");
		String world = getContent("worldKnowledge.xml");

		MutRoSe content = new MutRoSe(model, configHddl, configJson, world);
		try {

			Assert.assertTrue(true);
//			String result = service.generateBinMultRoSe(content);
//			Assert.assertTrue(!result.isEmpty());
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	@Test
	public void test7() throws Exception {
		String model = getContent("model.txt");
		String configHddl = getContent("configHddl.hddl");
		String world = getContent("worldKnowledge.xml");

		MutRoSe content = new MutRoSe(model, configHddl, null, world);
		RuntimeException exception = assertThrows(RuntimeException.class, () -> service.generateBinMultRoSe(content));
	}

//
	@Test
	public void test8() throws Exception {
		String model = getContent("model.txt");
		String configJson = getContent("configFile.json");
		String configHddl = getContent("configHddl.hddl");

		MutRoSe content = new MutRoSe(model, configHddl, configJson, null);
		RuntimeException exception = assertThrows(RuntimeException.class, () -> service.generateBinMultRoSe(content));

	}

	@Test
	public void test9() throws Exception {
		String model = getContent("model.txt");
		String configJson = getContent("configFile.json");
		String world = getContent("worldKnowledge.xml");

		MutRoSe content = new MutRoSe(model, null, configJson, world);
		RuntimeException exception = assertThrows(RuntimeException.class, () -> service.generateBinMultRoSe(content));

	}

	@Test
	public void test10() throws Exception {
		String model = getContent("model.txt");
		String configJson = getContent("configFile.json");
		String world = getContent("worldKnowledge.xml");
		String configHddl = getContent("configHddl.hddl");

		MutRoSe content = new MutRoSe(model, null, null, null);
		RuntimeException exception = assertThrows(RuntimeException.class, () -> service.generateBinMultRoSe(content));

	}
}
