package net.alibaran.yurtici.service.interfaces;

import net.alibaran.yurtici.models.enumaration.ShipmentType;
import net.alibaran.yurtici.models.request.ShippingOrderVO;
import net.alibaran.yurtici.models.response.ShippingOrderResultVO;

import java.util.List;

public interface ShipmentInterface {
	ShippingOrderResultVO createShipment(ShippingOrderVO shippingOrderVO, ShipmentType shipmentType);
	ShippingOrderResultVO cancelShipment(List<String> cargoKeys);
	ShippingOrderResultVO queryShipment(List<String> cargoKeys);
}