package com.calisma.retrofitusing;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


@Controller
public class HomeController {
	
	List<Bilgiler> data = new ArrayList<Bilgiler>();
	
	public HomeController() {
		Services services = API.getClient().create(Services.class);
		Call<JsonData> dt = services.urunGetir("3ed9209e2e113aa95774cf7117db20b8", "0");
		dt.enqueue(new Callback<JsonData>() {
			
			@Override
			public void onResponse(Call<JsonData> arg0, Response<JsonData> arg1) {
				JsonData jdt = arg1.body();
				data = jdt.getProducts().get(0).getBilgiler();
			}
			
			@Override
			public void onFailure(Call<JsonData> arg0, Throwable arg1) {
				System.err.println("Hata : " + arg1.getMessage() );
			}
		});
	}
	
	
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		model.addAttribute("data", data);
		return "home";
	}


	
}
