import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Client {
    public static void main(String[] args) {
        final Product product=new Product();
        IProducer proxyProducter= (IProducer) Proxy.newProxyInstance(product.getClass().getClassLoader(), product.getClass().getInterfaces(),
                new InvocationHandler() {
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        //增强方法
                        Object returnValue =null;
                        Float money=(Float)args[0];
                        if("sale".equals(method.getName())){
                            returnValue = method.invoke(product,money*0.8f);
                        }
                        return returnValue;

                    }
                });
        proxyProducter.sale( 1000f);
    }

}
