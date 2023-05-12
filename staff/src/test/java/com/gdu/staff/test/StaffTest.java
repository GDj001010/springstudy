package com.gdu.staff.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.gdu.staff.domain.StaffDTO;
import com.gdu.staff.mapper.StaffMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class StaffTest {

	@Autowired
	private StaffMapper staffMapper;
	
	
	@Test
	public void 상세테스트() {
		assertNotNull(staffMapper.getQuery("11111"));
	}
	
	@Test
	public void 삽입테스트() {
		StaffDTO staffDTO = new StaffDTO("99999", "김기획", "기획부", 5000);
		
		assertEquals(1, staffMapper.addStaff(staffDTO));
		
	}

}
