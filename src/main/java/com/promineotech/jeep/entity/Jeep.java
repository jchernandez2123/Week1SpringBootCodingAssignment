/**
 * 
 */
package com.promineotech.jeep.entity;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 12086
 *
 */



@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Jeep {
private long modelPK;
private JeepModel modelId;
private int numDoors;
private int wheelSize;
private BigDecimal basePrice;
}
