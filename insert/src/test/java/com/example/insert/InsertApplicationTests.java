// package com.example.insert;

// import static org.junit.jupiter.api.Assertions.assertEquals;

// import org.junit.jupiter.api.Test;
// import org.springframework.boot.test.context.SpringBootTest;

// import com.example.insert.insert.ProductController;
// import com.example.insert.insert.insert;

// @SpringBootTest
// class InsertApplicationTests {
// insert obj=new insert();
// ProductController pc=new ProductController();

// 	@Test
// 	void contextLoads() {
// 		obj.setId(11);
// 		obj.setName("Cherry");
// 		String ans=pc.insertion_product(obj);
// 		assertEquals("success",ans);
// 	}

// }

package com.example.insert;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.insert.delete.delete;
import com.example.insert.delete.deletecontroller;
import com.example.insert.insert.ProductController;
import com.example.insert.insert.insert;
import com.example.insert.update.update;
import com.example.insert.update.updateController;

@SpringBootTest
class InsertApplicationTests {

    @Autowired
    private ProductController pc;
	@Autowired
private deletecontroller dc;
@Autowired 
private updateController uc;
    @Test
    void contextLoads() {
        insert obj = new insert();
        obj.setId(11);
        obj.setName("Cherry");
        String ans = pc.insertion_product(obj);
        assertEquals("Data inserted", ans);
    }

	@Test 
	void testmethod(){
		delete obj=new delete();
		obj.setId(11);
		String ans=dc.deleteProduct(11);
		assertEquals("Record deleted successfully", ans);
	}

	@Test
	void testupdate(){
		update obj=new update();
		obj.setId(1);
		obj.setName("chandini");
		Map<String,String> mp=uc.postMethodName(obj);
		assertEquals("success",mp.get("s") );
	}


}
