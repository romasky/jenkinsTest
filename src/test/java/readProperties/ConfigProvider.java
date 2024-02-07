package readProperties;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

/*
в классе ConfigProvider. В текущей реализации метод readConfig() сначала проверяет наличие системного свойства "testProfile"
с помощью ConfigFactory.systemProperties().hasPath("testProfile").
Если такое свойство существует, он загружает конфигурацию из файла, указанного в этом свойстве,
с помощью ConfigFactory.load(ConfigFactory.systemProperties().getString("testProfile")).
В противном случае он загружает конфигурацию из файла "application.conf" с помощью ConfigFactory.load("application.conf").
 */

public interface ConfigProvider {
    Config config = readConfig();

    static Config readConfig() {
        return ConfigFactory.systemProperties().hasPath("testProfile")
                ? ConfigFactory.load(ConfigFactory.systemProperties().getString("testProfile"))
                : ConfigFactory.load("application.conf");
    }


    String URL = readConfig().getString("url");
    String BASIC_AUTH = readConfig().getString("basic_auth");
    String DIGEST_AUTH = readConfig().getString("digest_auth");
    String USER_LOGIN = readConfig().getString("usersParams.user.login");
    String USER_PASS = readConfig().getString("usersParams.user.password");

}
