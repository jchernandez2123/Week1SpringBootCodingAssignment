/**
 * 
 */
package com.promineotech.jeep.controller.support;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;
import com.promineotech.jeep.controller.JeepSalesController;
import com.promineotech.jeep.entity.Jeep;
import com.promineotech.jeep.entity.JeepModel;

/**
 * @author 12086
 *
 */

@RestController
public class BasicJeepSalesController implements JeepSalesController {

 
  
@Override
public List<Jeep> fetchJeeps(JeepModel model, String trim) {
  // TODO Auto-generated method stub
  return null;
}
}