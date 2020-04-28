/**
 * 
 */
package com.boco.share.function.transport.app.v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.boco.share.function.transport.bean.TransportHttpBean;
import com.boco.share.function.transport.service.inter.TransportService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * @author lv
 *
 */
@Api(tags = "交换平台-数据包数据传输")
@RestController
@RequestMapping("/api/v1/transport")
public class ApiTransportController {

	@Autowired
	private TransportService transportService;

	@ApiOperation(value = "发布数据包，同步数据接口，http")
	@ResponseBody
	@RequestMapping(value = "/getHttpDatas", method = RequestMethod.POST)
	public String getHttpDatas(
			@ApiParam(name = "transportHttpBean", value = "数据传输请求") @RequestBody TransportHttpBean transportHttpBean) {
		return transportService.getHttpDatas(transportHttpBean);
	}

	@ApiOperation(value = "发布数据包，同步数据接口，Wsdl")
	@ResponseBody
	@RequestMapping(value = "/getWsdlDatas", method = RequestMethod.POST)
	public String getWsdlDatas(
			@ApiParam(name = "transportHttpBean", value = "数据传输请求") @RequestBody TransportHttpBean transportHttpBean) {

		return "";
	}

}
