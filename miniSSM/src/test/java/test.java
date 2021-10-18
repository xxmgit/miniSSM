import com.bjpowernode.mapper.ProductInfoMapper;
import com.bjpowernode.mapper.ProductTypeMapper;
import com.bjpowernode.pojo.ProductInfo;
import com.bjpowernode.pojo.vo.ProductInfoVo;
import com.bjpowernode.utils.MD5Util;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext-dao.xml","classpath:applicationContext-service.xml"})
public class test {

    @Autowired
    ProductInfoMapper mapper;

    @Test
    public void testSelectCondition(){
      ProductInfoVo vo = new ProductInfoVo();
      vo.setPname("4");
      List<ProductInfo> list = mapper.selectCondition(vo);
      list.forEach(productInfo -> System.out.println(productInfo));
    }
}
