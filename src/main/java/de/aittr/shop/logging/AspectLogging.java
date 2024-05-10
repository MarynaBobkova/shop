package de.aittr.shop.logging;


import de.aittr.shop.domain.dto.ProductDto;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

//AspectJ framework
@Aspect
@Component
public class AspectLogging {

    private Logger logger = LoggerFactory.getLogger(AspectLogging.class);

    @Pointcut("execution(* de.aittr.shop.service.ProductServiceImpl.save(..))")
    public void saveProduct(){}

    @Before("saveProduct()")
    public void beforeSavingProduct(JoinPoint joinPoint){
        // Advice (адвайс) - тот код, который и будет внедряться в основной код,
        // используя правило, описанное в @Pointcut

        Object[] args = joinPoint.getArgs();
        logger.info("Method save of the class ProductServiceImpl called with parameter {}", args[0]);
    }

    @After("saveProduct()")
    public void afterSavingProduct(JoinPoint joinPoint){
        logger.info("Method save of the class ProductServiceImpl finished its work");
    }

    @Pointcut("execution(* de.aittr.shop.service.ProductServiceImpl.getById(..))")
    public void getProductById(){}

    @AfterReturning(pointcut = "getProductById()", returning = "result")
    public void afterReturningProductById(Object result){
        logger.info("Method getProductById() of the class ProductServiceImpl successfully return product {}", result);
    }

    @AfterThrowing(pointcut = "getProductById()", throwing = "e")
    public void afterThrowingAnExceptionWhileGettingProductById(Exception e) {
        logger.warn("Method getById of the class ProductServiceImpl threw an exception while getting product: " +
                "message - {}", e.getMessage());
    }

    @Pointcut("execution(* de.aittr.shop.service.ProductServiceImpl.getAll(..))")
    public void getAllProducts(){}

    @Around("getAllProducts()")
    public Object aroundGettingAllProducts(ProceedingJoinPoint joinPoint) throws Throwable {
        logger.info("Method getAllProducts() of the class ProductServiceImpl called");

        List<ProductDto> result = null;

        try {
            result = ((List<ProductDto>) joinPoint.proceed())
                    .stream()
                    .filter(x -> x.getPrice().compareTo(new BigDecimal(100)) > 0)
                    .toList();
        } catch (Throwable e) {
            logger.error("Method getAll of the class ProductServiceImpl threw an exception: {}", e.getMessage());
        }

        logger.info("Method getAllProducts() of the class ProductServiceImpl finished its work");
        return result;
    }
}
