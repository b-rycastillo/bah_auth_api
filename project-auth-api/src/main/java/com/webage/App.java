package com.webage;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.uber.jaeger.Configuration;
import com.uber.jaeger.samplers.ProbabilisticSampler;

@SpringBootApplication
public class App {

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

@Bean
public io.opentracing.Tracer jaegerTracer() {
    return new Configuration("auth-api", new Configuration.SamplerConfiguration(ProbabilisticSampler.TYPE, 1),
        new Configuration.ReporterConfiguration())
        .getTracer();
}
}
