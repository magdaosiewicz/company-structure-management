package com.example.company.configuratioin;

import org.springframework.context.annotation.Import;

/**
 * Created by Magda on 08.05.2018.
 */

@Import({ContextConfiguration.class, SwaggerConfiguration.class})
public class ImageConfiguration {
}
