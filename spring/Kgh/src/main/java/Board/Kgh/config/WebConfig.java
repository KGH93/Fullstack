package Board.Kgh.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.nio.file.Paths;

@Configuration
public class WebConfig{

    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // 실제 파일 저장 경로
        String uploadPath = Paths.get("src/main/resources/static/uploads").toAbsolutePath().toUri().toString();

        // "/uploads/**" 요청이 오면 해당 디렉토리에서 파일을 찾도록 설정
        registry.addResourceHandler("/uploads/**")
                .addResourceLocations(uploadPath);
    }
}
