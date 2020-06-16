package net.emamarquez.atms.atmapi;

import net.emamarquez.atms.atmapi.entity.Atm;
import net.emamarquez.atms.atmapi.service.AtmService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.assertj.core.api.Assertions.*;

import java.util.List;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class AtmApiApplicationTests {

	AtmService service = new AtmService();
	@Test
	void PruebaLlamadoApiRest() {

		List<Atm> testAtmList = service.getAtms();

		assertThat(testAtmList)
				.isNotEmpty();

        System.out.println("Test Succefull");


	}

}
