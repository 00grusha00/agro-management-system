# Agro Management System — Java Module Architecture

## 1. Модульдердің өзара әрекеттесу матрицасы

| Модуль атауы (Java Package) | Негізгі қызметі | Кіріс деректері | Шығыс нәтижесі | Тәуелділігі |
| :--- | :--- | :--- | :--- | :--- |
| **com.agro.model** | Датчиктер мен алқаптардың құрылымы (`record` / POJO) | `String id`, `double temp`, `double humidity` | `SensorReading` | Тәуелсіз ядро |
| **com.agro.repository** | Дерекқорға жазу және оқу (`interface` және `implements`) | `SensorReading` немесе `String fieldId` | `List<SensorReading>` немесе `boolean` | `com.agro.model` |
| **com.agro.service** | Валидация, нормамен салыстыру, шешім қабылдау | Көрсеткіштер, сұраныстар | Талдау есебі (`String` / DTO), ескерту | `model`, `repository` (`interface`) |
| **com.agro.ui** | Пайдаланушы сұранысын алу және нәтиже көрсету | Пайдаланушы әрекеті / HTTP сұраныс | Консоль кестесі немесе JSON | `service`, `model` |

## 2. Java интерфейстік келісімшарты (UI -> SensorService)

* `String analyzeFieldCondition(String fieldId)` — алқап жағдайы бойынша талдау есебі мен ескертуді қайтарады.
* `boolean registerNewSensorData(String fieldId, double temperature, double humidity)` — деректерді тексеріп сақтайды (`true` немесе қате кезінде `false` / `IllegalArgumentException`).

## 3. Интеграция схемасы

![Java Module Architecture Diagram](docs/architecture-diagram.png)