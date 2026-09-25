import java.util.*;

public class ResumeAnalyzer {

    // =========================================================
    // MAIN ANALYZER
    // =========================================================

    public String analyzeResume(String resumeText) {

        String text = normalize(resumeText);

        // -----------------------------------------------------
        // PROGRAMMING LANGUAGES
        // -----------------------------------------------------

        boolean java = has(text, "java");
        boolean python = has(text, "python");
        boolean c = has(text, "c programming", "c language");
        boolean cpp = has(text, "c++", "cpp");
        boolean csharp = has(text, "c#", "c sharp");
        boolean javascript = has(text, "javascript", "java script");
        boolean typescript = has(text, "typescript");
        boolean kotlin = has(text, "kotlin");
        boolean swift = has(text, "swift");
        boolean go = has(text, "golang", "go programming");
        boolean rust = has(text, "rust programming");
        boolean php = has(text, "php");
        boolean ruby = has(text, "ruby");
        boolean r = has(text, "r programming", "r language");
        boolean matlab = has(text, "matlab");
        boolean dart = has(text, "dart");
        boolean scala = has(text, "scala");

        // -----------------------------------------------------
        // PROGRAMMING CONCEPTS
        // -----------------------------------------------------

        boolean dsa = has(text,
                "data structures",
                "data structure",
                "algorithms",
                "algorithm",
                "dsa");

        boolean oop = has(text,
                "object oriented programming",
                "object-oriented programming",
                "oops",
                "oop");

        boolean problemSolving = has(text,
                "problem solving",
                "problem-solving");

        boolean multithreading = has(text,
                "multithreading",
                "multi threading",
                "concurrency");

        boolean collections = has(text,
                "java collections",
                "collections framework",
                "collections");

        boolean exceptionHandling = has(text,
                "exception handling");

        // -----------------------------------------------------
        // JAVA ECOSYSTEM
        // -----------------------------------------------------

        boolean jdbc = has(text, "jdbc");
        boolean spring = has(text, "spring framework");
        boolean springBoot = has(text, "spring boot", "springboot");
        boolean springMvc = has(text, "spring mvc");
        boolean hibernate = has(text, "hibernate");
        boolean jpa = has(text, "jpa");
        boolean maven = has(text, "maven");
        boolean gradle = has(text, "gradle");
        boolean junit = has(text, "junit");
        boolean mockito = has(text, "mockito");
        boolean microservices = has(text, "microservices", "microservices architecture");

        // -----------------------------------------------------
        // DATABASES
        // -----------------------------------------------------

        boolean sql = has(text,
                "sql",
                "mysql",
                "postgresql",
                "postgres",
                "sql server",
                "oracle");

        boolean mysql = has(text, "mysql");
        boolean postgresql = has(text, "postgresql", "postgres");
        boolean oracle = has(text, "oracle");
        boolean sqlServer = has(text, "sql server", "microsoft sql server");
        boolean mongodb = has(text, "mongodb", "mongo db");
        boolean redis = has(text, "redis");
        boolean sqlite = has(text, "sqlite");
        boolean databaseDesign = has(text,
                "database design",
                "database management",
                "dbms");

        // -----------------------------------------------------
        // WEB DEVELOPMENT
        // -----------------------------------------------------

        boolean html = has(text, "html");
        boolean css = has(text, "css");
        boolean bootstrap = has(text, "bootstrap");
        boolean tailwind = has(text, "tailwind", "tailwind css");
        boolean react = has(text, "react", "react.js", "reactjs");
        boolean angular = has(text, "angular");
        boolean vue = has(text, "vue.js", "vuejs", "vue");
        boolean nextjs = has(text, "next.js", "nextjs");
        boolean nodejs = has(text, "node.js", "nodejs", "node js");
        boolean express = has(text, "express.js", "expressjs");
        boolean graphql = has(text, "graphql");
        boolean restApi = has(text,
                "rest api",
                "restful api",
                "restful services",
                "rest services");
        boolean json = has(text, "json");
        boolean xml = has(text, "xml");

        // -----------------------------------------------------
        // DATA ANALYTICS
        // -----------------------------------------------------

        boolean excel = has(text,
                "excel",
                "microsoft excel",
                "ms excel");

        boolean advancedExcel = has(text,
                "advanced excel",
                "pivot table",
                "pivot tables",
                "xlookup",
                "vlookup");

        boolean powerbi = has(text,
                "power bi",
                "powerbi");

        boolean tableau = has(text, "tableau");

        boolean dax = has(text, "dax");

        boolean powerQuery = has(text,
                "power query");

        boolean pandas = has(text, "pandas");
        boolean numpy = has(text, "numpy");
        boolean matplotlib = has(text, "matplotlib");
        boolean seaborn = has(text, "seaborn");

        boolean statistics = has(text,
                "statistics",
                "statistical analysis",
                "statistical");

        boolean dataCleaning = has(text,
                "data cleaning",
                "data cleansing",
                "data preprocessing");

        boolean dataVisualization = has(text,
                "data visualization",
                "data visualisation");

        boolean etl = has(text,
                "etl",
                "extract transform load");

        boolean dataWarehouse = has(text,
                "data warehouse",
                "data warehousing");

        // -----------------------------------------------------
        // AI / MACHINE LEARNING
        // -----------------------------------------------------

        boolean machineLearning = has(text,
                "machine learning",
                "machine-learning");

        boolean deepLearning = has(text,
                "deep learning",
                "deep-learning");

        boolean tensorflow = has(text, "tensorflow");
        boolean pytorch = has(text, "pytorch");
        boolean keras = has(text, "keras");
        boolean sklearn = has(text,
                "scikit-learn",
                "scikit learn");

        boolean nlp = has(text,
                "natural language processing",
                "nlp");

        boolean computerVision = has(text,
                "computer vision");

        boolean opencv = has(text, "opencv");

        boolean generativeAI = has(text,
                "generative ai",
                "generative artificial intelligence");

        boolean llm = has(text,
                "large language model",
                "large language models",
                "llm",
                "llms");

        boolean promptEngineering = has(text,
                "prompt engineering",
                "prompting");

        boolean dataMining = has(text,
                "data mining");

        boolean timeSeries = has(text,
                "time series",
                "time-series");

        // -----------------------------------------------------
        // CLOUD
        // -----------------------------------------------------

        boolean aws = has(text,
                "aws",
                "amazon web services");

        boolean azure = has(text,
                "microsoft azure",
                "azure");

        boolean gcp = has(text,
                "google cloud",
                "gcp");

        boolean ec2 = has(text, "ec2");
        boolean s3 = has(text, "aws s3", "amazon s3");
        boolean lambda = has(text, "aws lambda");

        // -----------------------------------------------------
        // DEVOPS
        // -----------------------------------------------------

        boolean git = has(text,
                "git",
                "github",
                "gitlab");

        boolean docker = has(text, "docker");
        boolean kubernetes = has(text, "kubernetes", "k8s");
        boolean jenkins = has(text, "jenkins");

        boolean cicd = has(text,
                "ci/cd",
                "cicd",
                "continuous integration",
                "continuous deployment");

        boolean terraform = has(text, "terraform");
        boolean ansible = has(text, "ansible");

        boolean linux = has(text,
                "linux",
                "ubuntu");

        boolean shell = has(text,
                "shell scripting",
                "bash",
                "shell script");

        boolean githubActions = has(text,
                "github actions");

        // -----------------------------------------------------
        // CYBERSECURITY
        // -----------------------------------------------------

        boolean cybersecurity = has(text,
                "cybersecurity",
                "cyber security");

        boolean ethicalHacking = has(text,
                "ethical hacking");

        boolean penetrationTesting = has(text,
                "penetration testing",
                "penetration testing");

        boolean networkSecurity = has(text,
                "network security");

        boolean cryptography = has(text,
                "cryptography",
                "cryptographic");

        boolean owasp = has(text, "owasp");

        boolean kaliLinux = has(text, "kali linux");

        boolean soc = has(text,
                "security operations center",
                "security operations centre",
                "soc analyst");

        // -----------------------------------------------------
        // NETWORKING
        // -----------------------------------------------------

        boolean networking = has(text,
                "computer networks",
                "computer networking",
                "networking");

        boolean tcpip = has(text,
                "tcp/ip",
                "tcp ip");

        boolean dns = has(text, "dns");

        boolean http = has(text, "http", "https");

        boolean routing = has(text,
                "routing",
                "routers");

        boolean switching = has(text,
                "switching",
                "switches");

        // -----------------------------------------------------
        // TESTING
        // -----------------------------------------------------

        boolean softwareTesting = has(text,
                "software testing",
                "software test");

        boolean selenium = has(text, "selenium");

        boolean automationTesting = has(text,
                "automation testing",
                "automated testing");

        boolean apiTesting = has(text,
                "api testing");

        boolean integrationTesting = has(text,
                "integration testing");

        boolean unitTesting = has(text,
                "unit testing");

        // -----------------------------------------------------
        // ECE / VLSI
        // -----------------------------------------------------

        boolean digitalElectronics = has(text,
                "digital electronics",
                "digital logic");

        boolean analogElectronics = has(text,
                "analog electronics",
                "analogue electronics");

        boolean signals = has(text,
                "signals and systems",
                "signals & systems");

        boolean communicationSystems = has(text,
                "communication systems",
                "digital communication");

        boolean vlsi = has(text,
                "vlsi",
                "very large scale integration");

        boolean verilog = has(text,
                "verilog");

        boolean systemVerilog = has(text,
                "systemverilog",
                "system verilog");

        boolean uvm = has(text, "uvm");

        boolean rtl = has(text,
                "rtl design",
                "rtl");

        boolean rtlVerification = has(text,
                "rtl verification");

        boolean fpga = has(text, "fpga");

        boolean asic = has(text, "asic");

        boolean cmos = has(text, "cmos");

        boolean synthesis = has(text,
                "synthesis",
                "logic synthesis");

        boolean sta = has(text,
                "static timing analysis",
                "sta");

        boolean physicalDesign = has(text,
                "physical design");

        boolean cadence = has(text, "cadence");

        boolean synopsys = has(text, "synopsys");

        boolean vivado = has(text,
                "vivado",
                "xilinx vivado");

        boolean modelsim = has(text,
                "modelsim",
                "model sim");

        boolean quartus = has(text,
                "quartus",
                "intel quartus");

        // -----------------------------------------------------
        // EMBEDDED / IOT
        // -----------------------------------------------------

        boolean embedded = has(text,
                "embedded systems",
                "embedded system");

        boolean microcontroller = has(text,
                "microcontroller",
                "microcontrollers");

        boolean arm = has(text,
                "arm",
                "arm cortex");

        boolean stm32 = has(text, "stm32");

        boolean esp32 = has(text, "esp32");

        boolean arduino = has(text, "arduino");

        boolean raspberryPi = has(text,
                "raspberry pi",
                "raspberrypi");

        boolean iot = has(text,
                "iot",
                "internet of things");

        boolean rtos = has(text,
                "rtos",
                "real time operating system");

        boolean uart = has(text, "uart");

        boolean spi = has(text, "spi");

        boolean i2c = has(text,
                "i2c",
                "i²c");

        boolean canBus = has(text,
                "can bus",
                "controller area network");

        // -----------------------------------------------------
        // PCB / HARDWARE
        // -----------------------------------------------------

        boolean pcb = has(text,
                "pcb",
                "pcb design");

        boolean kicad = has(text, "kicad");

        boolean altium = has(text, "altium");

        boolean proteus = has(text, "proteus");

        boolean multisim = has(text, "multisim");

        boolean simulink = has(text, "simulink");

        // -----------------------------------------------------
        // AUTOMATION / INDUSTRIAL
        // -----------------------------------------------------

        boolean plc = has(text, "plc");

        boolean scada = has(text, "scada");

        boolean industrialAutomation = has(text,
                "industrial automation");

        // -----------------------------------------------------
        // SOFT SKILLS
        // -----------------------------------------------------

        boolean communication = has(text,
                "communication skills",
                "communication");

        boolean leadership = has(text, "leadership");

        boolean teamwork = has(text,
                "teamwork",
                "team work");

        boolean analyticalThinking = has(text,
                "analytical thinking",
                "analytical skills");

        boolean timeManagement = has(text,
                "time management");

        boolean presentation = has(text,
                "presentation skills",
                "presentation");

        boolean technicalWriting = has(text,
                "technical writing");

        // -----------------------------------------------------
        // ROLE SCORES
        // -----------------------------------------------------

        int javaDeveloper = 0;
        int dataAnalyst = 0;
        int webDeveloper = 0;
        int fullStack = 0;
        int pythonDeveloper = 0;
        int mlEngineer = 0;
        int cloudDevOps = 0;
        int cybersecurityRole = 0;
        int tester = 0;
        int networkEngineer = 0;
        int vlsiEngineer = 0;
        int fpgaEngineer = 0;
        int embeddedEngineer = 0;
        int iotEngineer = 0;
        int pcbEngineer = 0;
        int automationEngineer = 0;
        int databaseDeveloper = 0;

        // Java Developer
        if (java) javaDeveloper += 3;
        if (oop) javaDeveloper++;
        if (dsa) javaDeveloper++;
        if (sql) javaDeveloper++;
        if (jdbc) javaDeveloper++;
        if (spring) javaDeveloper++;
        if (springBoot) javaDeveloper += 2;
        if (hibernate) javaDeveloper++;
        if (jpa) javaDeveloper++;
        if (maven) javaDeveloper++;
        if (junit) javaDeveloper++;
        if (git) javaDeveloper++;

        // Data Analyst
        if (sql) dataAnalyst += 2;
        if (excel) dataAnalyst += 2;
        if (powerbi) dataAnalyst += 2;
        if (tableau) dataAnalyst++;
        if (dax) dataAnalyst++;
        if (powerQuery) dataAnalyst++;
        if (pandas) dataAnalyst++;
        if (numpy) dataAnalyst++;
        if (statistics) dataAnalyst++;
        if (dataCleaning) dataAnalyst++;
        if (dataVisualization) dataAnalyst++;
        if (etl) dataAnalyst++;

        // Web Developer
        if (html) webDeveloper += 2;
        if (css) webDeveloper += 2;
        if (javascript) webDeveloper += 3;
        if (typescript) webDeveloper++;
        if (react) webDeveloper += 2;
        if (angular) webDeveloper++;
        if (vue) webDeveloper++;
        if (bootstrap) webDeveloper++;
        if (tailwind) webDeveloper++;
        if (git) webDeveloper++;

        // Full Stack
        if (html) fullStack++;
        if (css) fullStack++;
        if (javascript) fullStack += 2;
        if (react) fullStack++;
        if (angular) fullStack++;
        if (nodejs) fullStack += 2;
        if (express) fullStack++;
        if (sql) fullStack++;
        if (mongodb) fullStack++;
        if (restApi) fullStack++;
        if (git) fullStack++;

        // Python Developer
        if (python) pythonDeveloper += 3;
        if (oop) pythonDeveloper++;
        if (dsa) pythonDeveloper++;
        if (sql) pythonDeveloper++;
        if (pandas) pythonDeveloper++;
        if (numpy) pythonDeveloper++;
        if (git) pythonDeveloper++;

        // ML Engineer
        if (python) mlEngineer += 2;
        if (machineLearning) mlEngineer += 3;
        if (deepLearning) mlEngineer += 2;
        if (pandas) mlEngineer++;
        if (numpy) mlEngineer++;
        if (sklearn) mlEngineer++;
        if (tensorflow) mlEngineer++;
        if (pytorch) mlEngineer++;
        if (statistics) mlEngineer++;
        if (nlp) mlEngineer++;
        if (computerVision) mlEngineer++;

        // Cloud / DevOps
        if (aws) cloudDevOps += 2;
        if (azure) cloudDevOps += 2;
        if (gcp) cloudDevOps += 2;
        if (docker) cloudDevOps += 2;
        if (kubernetes) cloudDevOps += 2;
        if (linux) cloudDevOps++;
        if (git) cloudDevOps++;
        if (jenkins) cloudDevOps++;
        if (cicd) cloudDevOps += 2;
        if (terraform) cloudDevOps++;
        if (ansible) cloudDevOps++;
        if (githubActions) cloudDevOps++;

        // Cybersecurity
        if (cybersecurity) cybersecurityRole += 3;
        if (ethicalHacking) cybersecurityRole += 2;
        if (penetrationTesting) cybersecurityRole += 2;
        if (networkSecurity) cybersecurityRole += 2;
        if (cryptography) cybersecurityRole++;
        if (owasp) cybersecurityRole++;
        if (kaliLinux) cybersecurityRole++;
        if (soc) cybersecurityRole += 2;
        if (networking) cybersecurityRole++;

        // Software Testing
        if (softwareTesting) tester += 3;
        if (selenium) tester += 2;
        if (automationTesting) tester += 2;
        if (apiTesting) tester++;
        if (unitTesting) tester++;
        if (integrationTesting) tester++;
        if (junit) tester++;
        if (git) tester++;

        // Network Engineer
        if (networking) networkEngineer += 3;
        if (tcpip) networkEngineer++;
        if (dns) networkEngineer++;
        if (routing) networkEngineer += 2;
        if (switching) networkEngineer += 2;
        if (networkSecurity) networkEngineer++;

        // VLSI Engineer
        if (vlsi) vlsiEngineer += 3;
        if (verilog) vlsiEngineer += 2;
        if (systemVerilog) vlsiEngineer += 2;
        if (rtl) vlsiEngineer += 2;
        if (rtlVerification) vlsiEngineer += 2;
        if (uvm) vlsiEngineer++;
        if (asic) vlsiEngineer++;
        if (cmos) vlsiEngineer++;
        if (synthesis) vlsiEngineer++;
        if (sta) vlsiEngineer++;
        if (cadence) vlsiEngineer++;
        if (synopsys) vlsiEngineer++;

        // FPGA Engineer
        if (fpga) fpgaEngineer += 3;
        if (verilog) fpgaEngineer += 2;
        if (systemVerilog) fpgaEngineer++;
        if (vivado) fpgaEngineer += 2;
        if (quartus) fpgaEngineer++;
        if (modelsim) fpgaEngineer++;
        if (digitalElectronics) fpgaEngineer++;

        // Embedded Engineer
        if (embedded) embeddedEngineer += 3;
        if (c) embeddedEngineer += 2;
        if (cpp) embeddedEngineer++;
        if (microcontroller) embeddedEngineer += 2;
        if (arm) embeddedEngineer++;
        if (stm32) embeddedEngineer++;
        if (esp32) embeddedEngineer++;
        if (rtos) embeddedEngineer++;
        if (uart) embeddedEngineer++;
        if (spi) embeddedEngineer++;
        if (i2c) embeddedEngineer++;
        if (git) embeddedEngineer++;

        // IoT Engineer
        if (iot) iotEngineer += 3;
        if (embedded) iotEngineer++;
        if (arduino) iotEngineer++;
        if (esp32) iotEngineer++;
        if (raspberryPi) iotEngineer++;
        if (microcontroller) iotEngineer++;
        if (mqtt(text)) iotEngineer += 2;
        if (python) iotEngineer++;
        if (cpp) iotEngineer++;

        // PCB Engineer
        if (pcb) pcbEngineer += 3;
        if (kicad) pcbEngineer += 2;
        if (altium) pcbEngineer += 2;
        if (proteus) pcbEngineer++;
        if (multisim) pcbEngineer++;
        if (digitalElectronics) pcbEngineer++;
        if (analogElectronics) pcbEngineer++;

        // Industrial Automation
        if (plc) automationEngineer += 3;
        if (scada) automationEngineer += 3;
        if (industrialAutomation) automationEngineer += 2;
        if (embedded) automationEngineer++;
        if (networking) automationEngineer++;

        // Database Developer
        if (sql) databaseDeveloper += 3;
        if (mysql) databaseDeveloper++;
        if (postgresql) databaseDeveloper++;
        if (oracle) databaseDeveloper++;
        if (sqlServer) databaseDeveloper++;
        if (mongodb) databaseDeveloper++;
        if (redis) databaseDeveloper++;
        if (databaseDesign) databaseDeveloper += 2;

        // -----------------------------------------------------
        // FIND HIGHEST ROLE
        // -----------------------------------------------------

        String targetRole = "Entry-Level IT / Software Role";
        int highest = 0;

        if (javaDeveloper > highest) {
            highest = javaDeveloper;
            targetRole = "Java Developer";
        }

        if (dataAnalyst > highest) {
            highest = dataAnalyst;
            targetRole = "Data Analyst";
        }

        if (webDeveloper > highest) {
            highest = webDeveloper;
            targetRole = "Web Developer";
        }

        if (fullStack > highest) {
            highest = fullStack;
            targetRole = "Full Stack Developer";
        }

        if (pythonDeveloper > highest) {
            highest = pythonDeveloper;
            targetRole = "Python Developer";
        }

        if (mlEngineer > highest) {
            highest = mlEngineer;
            targetRole = "Machine Learning Engineer";
        }

        if (cloudDevOps > highest) {
            highest = cloudDevOps;
            targetRole = "Cloud / DevOps Engineer";
        }

        if (cybersecurityRole > highest) {
            highest = cybersecurityRole;
            targetRole = "Cybersecurity Analyst";
        }

        if (tester > highest) {
            highest = tester;
            targetRole = "Software Test Engineer";
        }

        if (networkEngineer > highest) {
            highest = networkEngineer;
            targetRole = "Network Engineer";
        }

        if (vlsiEngineer > highest) {
            highest = vlsiEngineer;
            targetRole = "VLSI Design / Verification Engineer";
        }

        if (fpgaEngineer > highest) {
            highest = fpgaEngineer;
            targetRole = "FPGA Engineer";
        }

        if (embeddedEngineer > highest) {
            highest = embeddedEngineer;
            targetRole = "Embedded Systems Engineer";
        }

        if (iotEngineer > highest) {
            highest = iotEngineer;
            targetRole = "IoT Engineer";
        }

        if (pcbEngineer > highest) {
            highest = pcbEngineer;
            targetRole = "PCB Design Engineer";
        }

        if (automationEngineer > highest) {
            highest = automationEngineer;
            targetRole = "Industrial Automation Engineer";
        }

        if (databaseDeveloper > highest) {
            highest = databaseDeveloper;
            targetRole = "Database Developer";
        }

        // -----------------------------------------------------
        // COUNT DETECTED SKILLS
        // -----------------------------------------------------

        boolean[] allSkills = {

                java, python, c, cpp, csharp, javascript,
                typescript, kotlin, swift, go, rust, php,
                ruby, r, matlab, dart, scala,

                dsa, oop, problemSolving, multithreading,
                collections, exceptionHandling,

                jdbc, spring, springBoot, springMvc,
                hibernate, jpa, maven, gradle, junit,
                mockito, microservices,

                sql, mysql, postgresql, oracle, sqlServer,
                mongodb, redis, sqlite, databaseDesign,

                html, css, bootstrap, tailwind, react,
                angular, vue, nextjs, nodejs, express,
                graphql, restApi, json, xml,

                excel, advancedExcel, powerbi, tableau,
                dax, powerQuery, pandas, numpy, matplotlib,
                seaborn, statistics, dataCleaning,
                dataVisualization, etl, dataWarehouse,

                machineLearning, deepLearning, tensorflow,
                pytorch, keras, sklearn, nlp, computerVision,
                opencv, generativeAI, llm, promptEngineering,
                dataMining, timeSeries,

                aws, azure, gcp, ec2, s3, lambda,

                git, docker, kubernetes, jenkins, cicd,
                terraform, ansible, linux, shell, githubActions,

                cybersecurity, ethicalHacking, penetrationTesting,
                networkSecurity, cryptography, owasp,
                kaliLinux, soc,

                networking, tcpip, dns, http, routing,
                switching,

                softwareTesting, selenium, automationTesting,
                apiTesting, integrationTesting, unitTesting,

                digitalElectronics, analogElectronics, signals,
                communicationSystems, vlsi, verilog,
                systemVerilog, uvm, rtl, rtlVerification,
                fpga, asic, cmos, synthesis, sta,
                physicalDesign, cadence, synopsys, vivado,
                modelsim, quartus,

                embedded, microcontroller, arm, stm32, esp32,
                arduino, raspberryPi, iot, rtos, uart,
                spi, i2c, canBus,

                pcb, kicad, altium, proteus, multisim,
                simulink,

                plc, scada, industrialAutomation,

                communication, leadership, teamwork,
                analyticalThinking, timeManagement,
                presentation, technicalWriting
        };

        int skillCount = 0;

        for (boolean skill : allSkills) {
            if (skill) {
                skillCount++;
            }
        }

        // -----------------------------------------------------
        // SCORE
        // -----------------------------------------------------

        double score;

        if (skillCount == 0) {
            score = 3.0;
        } else if (skillCount <= 5) {
            score = 5.0;
        } else if (skillCount <= 10) {
            score = 6.0;
        } else if (skillCount <= 20) {
            score = 7.0;
        } else if (skillCount <= 35) {
            score = 8.0;
        } else if (skillCount <= 50) {
            score = 9.0;
        } else {
            score = 10.0;
        }

        // -----------------------------------------------------
        // BUILD OUTPUT
        // -----------------------------------------------------

        StringBuilder result = new StringBuilder();

        result.append("📄 RESUME ANALYSIS\n");
        result.append("━━━━━━━━━━━━━━━━━━━━\n\n");

        result.append(String.format(
                "⭐ Overall Score: %.1f/10\n\n",
                score
        ));

        result.append("🎯 TARGET JOB ROLE\n");
        result.append("• ").append(targetRole).append("\n\n");

        result.append("📊 SKILL COVERAGE\n");
        result.append("• ").append(skillCount)
              .append(" relevant skills detected\n\n");

        // -----------------------------------------------------
        // FOUND SKILLS
        // -----------------------------------------------------

        result.append("✅ SKILLS FOUND\n");

        appendSkill(result, java, "Java");
        appendSkill(result, python, "Python");
        appendSkill(result, c, "C");
        appendSkill(result, cpp, "C++");
        appendSkill(result, csharp, "C#");
        appendSkill(result, javascript, "JavaScript");
        appendSkill(result, typescript, "TypeScript");
        appendSkill(result, kotlin, "Kotlin");
        appendSkill(result, swift, "Swift");
        appendSkill(result, go, "Go");
        appendSkill(result, rust, "Rust");
        appendSkill(result, php, "PHP");
        appendSkill(result, ruby, "Ruby");
        appendSkill(result, r, "R");
        appendSkill(result, matlab, "MATLAB");
        appendSkill(result, dart, "Dart");
        appendSkill(result, scala, "Scala");

        appendSkill(result, dsa, "Data Structures & Algorithms");
        appendSkill(result, oop, "OOP");
        appendSkill(result, problemSolving, "Problem Solving");
        appendSkill(result, multithreading, "Multithreading");
        appendSkill(result, collections, "Collections");
        appendSkill(result, exceptionHandling, "Exception Handling");

        appendSkill(result, jdbc, "JDBC");
        appendSkill(result, spring, "Spring");
        appendSkill(result, springBoot, "Spring Boot");
        appendSkill(result, springMvc, "Spring MVC");
        appendSkill(result, hibernate, "Hibernate");
        appendSkill(result, jpa, "JPA");
        appendSkill(result, maven, "Maven");
        appendSkill(result, gradle, "Gradle");
        appendSkill(result, junit, "JUnit");
        appendSkill(result, mockito, "Mockito");
        appendSkill(result, microservices, "Microservices");

        appendSkill(result, sql, "SQL");
        appendSkill(result, mysql, "MySQL");
        appendSkill(result, postgresql, "PostgreSQL");
        appendSkill(result, oracle, "Oracle");
        appendSkill(result, sqlServer, "SQL Server");
        appendSkill(result, mongodb, "MongoDB");
        appendSkill(result, redis, "Redis");
        appendSkill(result, sqlite, "SQLite");
        appendSkill(result, databaseDesign, "Database Design");

        appendSkill(result, html, "HTML");
        appendSkill(result, css, "CSS");
        appendSkill(result, bootstrap, "Bootstrap");
        appendSkill(result, tailwind, "Tailwind CSS");
        appendSkill(result, react, "React");
        appendSkill(result, angular, "Angular");
        appendSkill(result, vue, "Vue.js");
        appendSkill(result, nextjs, "Next.js");
        appendSkill(result, nodejs, "Node.js");
        appendSkill(result, express, "Express.js");
        appendSkill(result, graphql, "GraphQL");
        appendSkill(result, restApi, "REST API");
        appendSkill(result, json, "JSON");
        appendSkill(result, xml, "XML");

        appendSkill(result, excel, "Excel");
        appendSkill(result, advancedExcel, "Advanced Excel");
        appendSkill(result, powerbi, "Power BI");
        appendSkill(result, tableau, "Tableau");
        appendSkill(result, dax, "DAX");
        appendSkill(result, powerQuery, "Power Query");
        appendSkill(result, pandas, "Pandas");
        appendSkill(result, numpy, "NumPy");
        appendSkill(result, matplotlib, "Matplotlib");
        appendSkill(result, seaborn, "Seaborn");
        appendSkill(result, statistics, "Statistics");
        appendSkill(result, dataCleaning, "Data Cleaning");
        appendSkill(result, dataVisualization, "Data Visualization");
        appendSkill(result, etl, "ETL");
        appendSkill(result, dataWarehouse, "Data Warehousing");

        appendSkill(result, machineLearning, "Machine Learning");
        appendSkill(result, deepLearning, "Deep Learning");
        appendSkill(result, tensorflow, "TensorFlow");
        appendSkill(result, pytorch, "PyTorch");
        appendSkill(result, keras, "Keras");
        appendSkill(result, sklearn, "Scikit-learn");
        appendSkill(result, nlp, "NLP");
        appendSkill(result, computerVision, "Computer Vision");
        appendSkill(result, opencv, "OpenCV");
        appendSkill(result, generativeAI, "Generative AI");
        appendSkill(result, llm, "LLM");
        appendSkill(result, promptEngineering, "Prompt Engineering");
        appendSkill(result, dataMining, "Data Mining");
        appendSkill(result, timeSeries, "Time Series");

        appendSkill(result, aws, "AWS");
        appendSkill(result, azure, "Azure");
        appendSkill(result, gcp, "Google Cloud");
        appendSkill(result, ec2, "AWS EC2");
        appendSkill(result, s3, "AWS S3");
        appendSkill(result, lambda, "AWS Lambda");

        appendSkill(result, git, "Git / GitHub");
        appendSkill(result, docker, "Docker");
        appendSkill(result, kubernetes, "Kubernetes");
        appendSkill(result, jenkins, "Jenkins");
        appendSkill(result, cicd, "CI/CD");
        appendSkill(result, terraform, "Terraform");
        appendSkill(result, ansible, "Ansible");
        appendSkill(result, linux, "Linux");
        appendSkill(result, shell, "Shell Scripting");
        appendSkill(result, githubActions, "GitHub Actions");

        appendSkill(result, cybersecurity, "Cybersecurity");
        appendSkill(result, ethicalHacking, "Ethical Hacking");
        appendSkill(result, penetrationTesting, "Penetration Testing");
        appendSkill(result, networkSecurity, "Network Security");
        appendSkill(result, cryptography, "Cryptography");
        appendSkill(result, owasp, "OWASP");
        appendSkill(result, kaliLinux, "Kali Linux");
        appendSkill(result, soc, "SOC");

        appendSkill(result, networking, "Computer Networking");
        appendSkill(result, tcpip, "TCP/IP");
        appendSkill(result, dns, "DNS");
        appendSkill(result, http, "HTTP/HTTPS");
        appendSkill(result, routing, "Routing");
        appendSkill(result, switching, "Switching");

        appendSkill(result, softwareTesting, "Software Testing");
        appendSkill(result, selenium, "Selenium");
        appendSkill(result, automationTesting, "Automation Testing");
        appendSkill(result, apiTesting, "API Testing");
        appendSkill(result, integrationTesting, "Integration Testing");
        appendSkill(result, unitTesting, "Unit Testing");

        appendSkill(result, digitalElectronics, "Digital Electronics");
        appendSkill(result, analogElectronics, "Analog Electronics");
        appendSkill(result, signals, "Signals & Systems");
        appendSkill(result, communicationSystems, "Communication Systems");
        appendSkill(result, vlsi, "VLSI");
        appendSkill(result, verilog, "Verilog");
        appendSkill(result, systemVerilog, "SystemVerilog");
        appendSkill(result, uvm, "UVM");
        appendSkill(result, rtl, "RTL Design");
        appendSkill(result, rtlVerification, "RTL Verification");
        appendSkill(result, fpga, "FPGA");
        appendSkill(result, asic, "ASIC");
        appendSkill(result, cmos, "CMOS");
        appendSkill(result, synthesis, "Logic Synthesis");
        appendSkill(result, sta, "Static Timing Analysis");
        appendSkill(result, physicalDesign, "Physical Design");
        appendSkill(result, cadence, "Cadence");
        appendSkill(result, synopsys, "Synopsys");
        appendSkill(result, vivado, "Vivado");
        appendSkill(result, modelsim, "ModelSim");
        appendSkill(result, quartus, "Quartus");

        appendSkill(result, embedded, "Embedded Systems");
        appendSkill(result, microcontroller, "Microcontrollers");
        appendSkill(result, arm, "ARM");
        appendSkill(result, stm32, "STM32");
        appendSkill(result, esp32, "ESP32");
        appendSkill(result, arduino, "Arduino");
        appendSkill(result, raspberryPi, "Raspberry Pi");
        appendSkill(result, iot, "IoT");
        appendSkill(result, rtos, "RTOS");
        appendSkill(result, uart, "UART");
        appendSkill(result, spi, "SPI");
        appendSkill(result, i2c, "I2C");
        appendSkill(result, canBus, "CAN Bus");

        appendSkill(result, pcb, "PCB Design");
        appendSkill(result, kicad, "KiCad");
        appendSkill(result, altium, "Altium");
        appendSkill(result, proteus, "Proteus");
        appendSkill(result, multisim, "Multisim");
        appendSkill(result, simulink, "Simulink");

        appendSkill(result, plc, "PLC");
        appendSkill(result, scada, "SCADA");
        appendSkill(result, industrialAutomation, "Industrial Automation");

        appendSkill(result, communication, "Communication");
        appendSkill(result, leadership, "Leadership");
        appendSkill(result, teamwork, "Teamwork");
        appendSkill(result, analyticalThinking, "Analytical Thinking");
        appendSkill(result, timeManagement, "Time Management");
        appendSkill(result, presentation, "Presentation");
        appendSkill(result, technicalWriting, "Technical Writing");

        // -----------------------------------------------------
        // ROLE-SPECIFIC SKILLS TO IMPROVE
        // -----------------------------------------------------

        result.append("\n❌ IMPORTANT SKILLS TO IMPROVE\n");

        addRoleGaps(
                result,
                targetRole,
                java, dsa, oop, sql, springBoot,
                restApi, git, hibernate,
                excel, powerbi, pandas, numpy,
                statistics, dataVisualization,
                python, machineLearning,
                sklearn, tensorflow, pytorch,
                html, css, javascript, react,
                nodejs, mongodb,
                aws, docker, kubernetes,
                linux, cicd,
                cybersecurity, networking,
                softwareTesting, selenium,
                vlsi, verilog, systemVerilog,
                rtl, fpga, vivado,
                embedded, c, microcontroller,
                iot, pcb, kicad
        );

        // -----------------------------------------------------
        // GENERAL SUGGESTIONS
        // -----------------------------------------------------

        result.append("\n💡 RESUME SUGGESTIONS\n");

        result.append(
                "• Keep your resume focused on the target job role.\n"
        );

        result.append(
                "• Add 2–3 strong projects related to your target role.\n"
        );

        result.append(
                "• Mention the technologies actually used in each project.\n"
        );

        result.append(
                "• Add GitHub/project links when available.\n"
        );

        result.append(
                "• Use measurable results instead of only describing responsibilities.\n"
        );

        if (!communication) {
            result.append(
                    "• Consider adding communication skills if you can demonstrate them.\n"
            );
        }

        if (!git) {
            result.append(
                    "• Learn Git and GitHub for project version control.\n"
            );
        }

        // -----------------------------------------------------
        // RECOMMENDED LEARNING
        // -----------------------------------------------------

        result.append("\n🎓 RECOMMENDED LEARNING\n\n");

        addLearning(
                result,
                targetRole,
                java, dsa, sql, springBoot,
                restApi, git, hibernate,
                excel, powerbi, pandas,
                numpy, statistics,
                python, machineLearning,
                sklearn, tensorflow,
                html, css, javascript,
                react, nodejs, mongodb,
                aws, docker, kubernetes,
                linux, cicd,
                cybersecurity, networking,
                softwareTesting, selenium,
                vlsi, verilog, systemVerilog,
                rtl, fpga, vivado,
                embedded, c, microcontroller,
                iot, pcb, kicad,cpp
        );

        return result.toString();
    }

    // =========================================================
    // NORMALIZE TEXT
    // =========================================================

    private String normalize(String text) {

        return text
                .toLowerCase()
                .replace("\r", " ")
                .replace("\n", " ")
                .replaceAll("\\s+", " ");
    }

    // =========================================================
    // SKILL CHECK
    // =========================================================

    private boolean has(
            String text,
            String... keywords) {

        for (String keyword : keywords) {

            if (text.contains(keyword.toLowerCase())) {
                return true;
            }
        }

        return false;
    }

    // =========================================================
    // MQTT CHECK
    // =========================================================

    private boolean mqtt(String text) {

        return has(
                text,
                "mqtt",
                "message queuing telemetry transport"
        );
    }

    // =========================================================
    // APPEND SKILL
    // =========================================================

    private void appendSkill(
            StringBuilder result,
            boolean present,
            String skill) {

        if (present) {
            result.append("• ")
                  .append(skill)
                  .append("\n");
        }
    }

    // =========================================================
    // ROLE GAPS
    // =========================================================

    private void addRoleGaps(
            StringBuilder result,
            String role,

            boolean java,
            boolean dsa,
            boolean oop,
            boolean sql,
            boolean springBoot,
            boolean restApi,
            boolean git,
            boolean hibernate,

            boolean excel,
            boolean powerbi,
            boolean pandas,
            boolean numpy,
            boolean statistics,
            boolean dataVisualization,

            boolean python,
            boolean machineLearning,
            boolean sklearn,
            boolean tensorflow,
            boolean pytorch,

            boolean html,
            boolean css,
            boolean javascript,
            boolean react,
            boolean nodejs,
            boolean mongodb,

            boolean aws,
            boolean docker,
            boolean kubernetes,
            boolean linux,
            boolean cicd,

            boolean cybersecurity,
            boolean networking,

            boolean softwareTesting,
            boolean selenium,

            boolean vlsi,
            boolean verilog,
            boolean systemVerilog,
            boolean rtl,
            boolean fpga,
            boolean vivado,

            boolean embedded,
            boolean c,
            boolean microcontroller,
            boolean iot,

            boolean pcb,
            boolean kicad) {

        int count = 0;

        if (role.equals("Java Developer")) {

            count += gap(result, !java, "Java");
            count += gap(result, !dsa,
                    "Data Structures & Algorithms");
            count += gap(result, !oop, "OOP");
            count += gap(result, !sql, "SQL");
            count += gap(result, !springBoot, "Spring Boot");
            count += gap(result, !restApi, "REST API");
            count += gap(result, !git, "Git / GitHub");
            count += gap(result, !hibernate, "Hibernate");

        } else if (role.equals("Data Analyst")) {

            count += gap(result, !sql, "SQL");
            count += gap(result, !excel, "Advanced Excel");
            count += gap(result, !powerbi, "Power BI");
            count += gap(result, !pandas, "Pandas");
            count += gap(result, !numpy, "NumPy");
            count += gap(result, !statistics, "Statistics");
            count += gap(result,
                    !dataVisualization,
                    "Data Visualization");

        } else if (role.equals("Machine Learning Engineer")) {

            count += gap(result, !python, "Python");
            count += gap(result,
                    !numpy,
                    "NumPy");

            count += gap(result,
                    !pandas,
                    "Pandas");

            count += gap(result,
                    !machineLearning,
                    "Machine Learning");

            count += gap(result,
                    !sklearn,
                    "Scikit-learn");

            count += gap(result,
                    !statistics,
                    "Statistics");

            count += gap(result,
                    !tensorflow && !pytorch,
                    "TensorFlow / PyTorch");

        } else if (role.equals("Full Stack Developer")) {

            count += gap(result, !html, "HTML");
            count += gap(result, !css, "CSS");
            count += gap(result, !javascript, "JavaScript");
            count += gap(result, !react, "React");
            count += gap(result, !nodejs, "Node.js");
            count += gap(result, !sql && !mongodb,
                    "Database");
            count += gap(result, !git, "Git / GitHub");

        } else if (role.equals("Web Developer")) {

            count += gap(result, !html, "HTML");
            count += gap(result, !css, "CSS");
            count += gap(result, !javascript, "JavaScript");
            count += gap(result, !react, "React");
            count += gap(result, !git, "Git / GitHub");

        } else if (role.equals("Python Developer")) {

            count += gap(result, !python, "Python");
            count += gap(result, !dsa,
                    "Data Structures & Algorithms");
            count += gap(result, !oop, "OOP");
            count += gap(result, !sql, "SQL");
            count += gap(result, !git, "Git / GitHub");

        } else if (role.equals("Cloud / DevOps Engineer")) {

            count += gap(result, !aws,
                    "AWS / Cloud Platform");

            count += gap(result, !linux,
                    "Linux");

            count += gap(result, !docker,
                    "Docker");

            count += gap(result, !kubernetes,
                    "Kubernetes");

            count += gap(result, !cicd,
                    "CI/CD");

            count += gap(result, !git,
                    "Git / GitHub");

        } else if (role.equals("Cybersecurity Analyst")) {

            count += gap(result, !cybersecurity,
                    "Cybersecurity");

            count += gap(result, !networking,
                    "Networking");

            count += gap(result,
                    !softwareTesting,
                    "Security Testing");

            count += gap(result,
                    !git,
                    "Git");

        } else if (role.equals("Software Test Engineer")) {

            count += gap(result,
                    !softwareTesting,
                    "Software Testing");

            count += gap(result,
                    !selenium,
                    "Selenium");

            count += gap(result,
                    !dsa,
                    "Programming / DSA");

            count += gap(result,
                    !sql,
                    "SQL");

            count += gap(result,
                    !git,
                    "Git / GitHub");

        } else if (role.equals(
                "VLSI Design / Verification Engineer")) {

            count += gap(result,
                    !digitalSkillPresent(result),
                    "Digital Electronics");

            count += gap(result,
                    !verilog,
                    "Verilog");

            count += gap(result,
                    !systemVerilog,
                    "SystemVerilog");

            count += gap(result,
                    !vlsi,
                    "VLSI");

            count += gap(result,
                    !rtl,
                    "RTL Design");

            count += gap(result,
                    !git,
                    "Git");

        } else if (role.equals("FPGA Engineer")) {

            count += gap(result,
                    !verilog,
                    "Verilog");

            count += gap(result,
                    !fpga,
                    "FPGA");

            count += gap(result,
                    !vivado,
                    "Vivado");

            count += gap(result,
                    !rtl,
                    "RTL Design");

        } else if (role.equals(
                "Embedded Systems Engineer")) {

            count += gap(result,
                    !c,
                    "C Programming");

            count += gap(result,
                    !embedded,
                    "Embedded Systems");

            count += gap(result,
                    !microcontroller,
                    "Microcontrollers");

            count += gap(result,
                    !iot,
                    "IoT");

            count += gap(result,
                    !git,
                    "Git");

        } else if (role.equals("IoT Engineer")) {

            count += gap(result,
                    !iot,
                    "IoT");

            count += gap(result,
                    !embedded,
                    "Embedded Systems");

            count += gap(result,
                    !microcontroller,
                    "Microcontrollers");

        } else if (role.equals(
                "PCB Design Engineer")) {

            count += gap(result,
                    !pcb,
                    "PCB Design");

            count += gap(result,
                    !kicad,
                    "KiCad / PCB Design Tool");

            count += gap(result,
                    !c,
                    "Basic Electronics / C");

        } else {

            count += gap(result,
                    !dsa,
                    "Data Structures & Algorithms");

            count += gap(result,
                    !sql,
                    "SQL");

            count += gap(result,
                    !git,
                    "Git / GitHub");

            count += gap(result,
                    !problemSolvingPresent(result),
                    "Problem Solving");
        }

        if (count == 0) {

            result.append(
                    "• No major role-specific skill gap detected.\n"
            );
        }
    }

    private int gap(
            StringBuilder result,
            boolean missing,
            String skill) {

        if (missing) {

            result.append("• ")
                  .append(skill)
                  .append("\n");

            return 1;
        }

        return 0;
    }

    private boolean digitalSkillPresent(
            StringBuilder result) {

        return result.toString()
                .contains("Digital Electronics");
    }

    private boolean problemSolvingPresent(
            StringBuilder result) {

        return result.toString()
                .contains("Problem Solving");
    }

    // =========================================================
    // LEARNING RECOMMENDATIONS
    // =========================================================

    private void addLearning(
            StringBuilder result,
            String role,

            boolean java,
            boolean dsa,
            boolean sql,
            boolean springBoot,
            boolean restApi,
            boolean git,
            boolean hibernate,

            boolean excel,
            boolean powerbi,
            boolean pandas,
            boolean numpy,
            boolean statistics,

            boolean python,
            boolean machineLearning,
            boolean sklearn,
            boolean tensorflow,

            boolean html,
            boolean css,
            boolean javascript,
            boolean react,
            boolean nodejs,
            boolean mongodb,

            boolean aws,
            boolean docker,
            boolean kubernetes,
            boolean linux,
            boolean cicd,

            boolean cybersecurity,
            boolean networking,

            boolean softwareTesting,
            boolean selenium,

            boolean vlsi,
            boolean verilog,
            boolean systemVerilog,
            boolean rtl,
            boolean fpga,
            boolean vivado,
boolean embedded,
boolean c,
boolean cpp,
boolean microcontroller,
boolean iot,

            boolean pcb,
            boolean kicad) {

        int added = 0;

        if (role.equals("Java Developer")) {

            if (!java && added < 6) {
                course(result,
                        "Java Learning",
                        "Java",
                        "https://dev.java/learn/");
                added++;
            }

            if (!dsa && added < 6) {
                course(result,
                        "Data Structures",
                        "DSA",
                        "https://www.geeksforgeeks.org/data-structures/");
                added++;
            }

            if (!sql && added < 6) {
                course(result,
                        "SQL Tutorial",
                        "SQL",
                        "https://www.w3schools.com/sql/");
                added++;
            }

            if (!springBoot && added < 6) {
                course(result,
                        "Spring Guides",
                        "Spring Boot",
                        "https://spring.io/guides");
                added++;
            }

            if (!restApi && added < 6) {
                course(result,
                        "REST API Guide",
                        "REST API",
                        "https://developer.mozilla.org/en-US/docs/Glossary/REST");
                added++;
            }

            if (!git && added < 6) {
                course(result,
                        "Git Documentation",
                        "Git",
                        "https://git-scm.com/doc");
                added++;
            }

        } else if (role.equals("Data Analyst")) {

            if (!sql && added < 6) {
                course(result,
                        "SQL Tutorial",
                        "SQL",
                        "https://www.w3schools.com/sql/");
                added++;
            }

            if (!excel && added < 6) {
                course(result,
                        "Excel Training",
                        "Excel",
                        "https://support.microsoft.com/excel");
                added++;
            }

            if (!powerbi && added < 6) {
                course(result,
                        "Power BI Learning",
                        "Power BI",
                        "https://learn.microsoft.com/power-bi/");
                added++;
            }

            if (!pandas && added < 6) {
                course(result,
                        "Pandas Documentation",
                        "Pandas",
                        "https://pandas.pydata.org/docs/");
                added++;
            }

            if (!numpy && added < 6) {
                course(result,
                        "NumPy Learning",
                        "NumPy",
                        "https://numpy.org/learn/");
                added++;
            }

            if (!statistics && added < 6) {
                course(result,
                        "Statistics",
                        "Statistics",
                        "https://www.khanacademy.org/math/statistics-probability");
                added++;
            }

        } else if (role.equals("Machine Learning Engineer")) {

            if (!python && added < 6) {
                course(result,
                        "Python Tutorial",
                        "Python",
                        "https://docs.python.org/3/tutorial/");
                added++;
            }

            if (!numpy && added < 6) {
                course(result,
                        "NumPy",
                        "NumPy",
                        "https://numpy.org/learn/");
                added++;
            }

            if (!pandas && added < 6) {
                course(result,
                        "Pandas",
                        "Pandas",
                        "https://pandas.pydata.org/docs/");
                added++;
            }

            if (!machineLearning && added < 6) {
                course(result,
                        "Machine Learning",
                        "Machine Learning",
                        "https://scikit-learn.org/stable/user_guide.html");
                added++;
            }

            if (!sklearn && added < 6) {
                course(result,
                        "Scikit-learn",
                        "Machine Learning",
                        "https://scikit-learn.org/stable/");
                added++;
            }

            if (!tensorflow && added < 6) {
                course(result,
                        "TensorFlow",
                        "Deep Learning",
                        "https://www.tensorflow.org/learn");
                added++;
            }

        } else if (role.equals("Full Stack Developer")) {

            if (!html && added < 6) {
                course(result,
                        "HTML",
                        "HTML",
                        "https://developer.mozilla.org/en-US/docs/Web/HTML");
                added++;
            }

            if (!css && added < 6) {
                course(result,
                        "CSS",
                        "CSS",
                        "https://developer.mozilla.org/en-US/docs/Web/CSS");
                added++;
            }

            if (!javascript && added < 6) {
                course(result,
                        "JavaScript",
                        "JavaScript",
                        "https://developer.mozilla.org/en-US/docs/Web/JavaScript");
                added++;
            }

            if (!react && added < 6) {
                course(result,
                        "React",
                        "React",
                        "https://react.dev/learn");
                added++;
            }

            if (!nodejs && added < 6) {
                course(result,
                        "Node.js",
                        "Node.js",
                        "https://nodejs.org/en/learn");
                added++;
            }

            if (!git && added < 6) {
                course(result,
                        "Git",
                        "Git",
                        "https://git-scm.com/doc");
                added++;
            }

        } else if (role.equals("Cloud / DevOps Engineer")) {

            if (!aws && added < 6) {
                course(result,
                        "AWS Training",
                        "Cloud",
                        "https://aws.amazon.com/training/");
                added++;
            }

            if (!linux && added < 6) {
                course(result,
                        "Ubuntu Tutorials",
                        "Linux",
                        "https://ubuntu.com/tutorials");
                added++;
            }

            if (!docker && added < 6) {
                course(result,
                        "Docker Get Started",
                        "Docker",
                        "https://docs.docker.com/get-started/");
                added++;
            }

            if (!kubernetes && added < 6) {
                course(result,
                        "Kubernetes Tutorials",
                        "Kubernetes",
                        "https://kubernetes.io/docs/tutorials/");
                added++;
            }

            if (!cicd && added < 6) {
                course(result,
                        "GitHub Actions",
                        "CI/CD",
                        "https://docs.github.com/en/actions");
                added++;
            }

            if (!git && added < 6) {
                course(result,
                        "Git",
                        "Git",
                        "https://git-scm.com/doc");
                added++;
            }

        } else if (role.equals("Cybersecurity Analyst")) {

            if (!cybersecurity && added < 6) {
                course(result,
                        "Cybersecurity",
                        "Cybersecurity",
                        "https://www.coursera.org/search?query=cybersecurity");
                added++;
            }

            if (!networking && added < 6) {
                course(result,
                        "Networking",
                        "Networking",
                        "https://www.cisco.com/c/en/us/training-events/training-certifications/training.html");
                added++;
            }

            if (!softwareTesting && added < 6) {
                course(result,
                        "Security Testing",
                        "Security Testing",
                        "https://owasp.org/");
                added++;
            }

        } else if (role.equals("Software Test Engineer")) {

            if (!softwareTesting && added < 6) {
                course(result,
                        "Software Testing",
                        "Testing",
                        "https://www.guru99.com/software-testing.html");
                added++;
            }

            if (!selenium && added < 6) {
                course(result,
                        "Selenium",
                        "Automation Testing",
                        "https://www.selenium.dev/documentation/");
                added++;
            }

            if (!sql && added < 6) {
                course(result,
                        "SQL",
                        "SQL",
                        "https://www.w3schools.com/sql/");
                added++;
            }

            if (!git && added < 6) {
                course(result,
                        "Git",
                        "Git",
                        "https://git-scm.com/doc");
                added++;
            }

        } else if (role.equals(
                "VLSI Design / Verification Engineer")) {

            if (!verilog && added < 6) {
                course(result,
                        "Verilog Tutorial",
                        "Verilog",
                        "https://www.chipverify.com/verilog/verilog-tutorial");
                added++;
            }

            if (!systemVerilog && added < 6) {
                course(result,
                        "SystemVerilog",
                        "SystemVerilog",
                        "https://www.chipverify.com/systemverilog/systemverilog-tutorial");
                added++;
            }

            if (!vlsi && added < 6) {
                course(result,
                        "VLSI Learning",
                        "VLSI",
                        "https://www.coursera.org/search?query=vlsi");
                added++;
            }

            if (!rtl && added < 6) {
                course(result,
                        "RTL Design",
                        "RTL",
                        "https://www.coursera.org/search?query=rtl%20design");
                added++;
            }

        } else if (role.equals("FPGA Engineer")) {

            if (!verilog && added < 6) {
                course(result,
                        "Verilog",
                        "Verilog",
                        "https://www.chipverify.com/verilog/verilog-tutorial");
                added++;
            }

            if (!fpga && added < 6) {
                course(result,
                        "FPGA Learning",
                        "FPGA",
                        "https://www.amd.com/en/products/adaptive-socs-and-fpgas/fpga.html");
                added++;
            }

            if (!vivado && added < 6) {
                course(result,
                        "Vivado",
                        "Vivado",
                        "https://www.amd.com/en/products/software/adaptive-socs-and-fpgas/vivado.html");
                added++;
            }

            if (!rtl && added < 6) {
                course(result,
                        "RTL Design",
                        "RTL",
                        "https://www.coursera.org/search?query=rtl%20design");
                added++;
            }

        } else if (role.equals(
                "Embedded Systems Engineer")) {

            if (!c && added < 6) {
                course(result,
                        "C Programming",
                        "C",
                        "https://www.learn-c.org/");
                added++;
            }

            if (!embedded && added < 6) {
                course(result,
                        "Embedded Systems",
                        "Embedded",
                        "https://www.coursera.org/search?query=embedded%20systems");
                added++;
            }

            if (!microcontroller && added < 6) {
                course(result,
                        "Microcontrollers",
                        "Microcontrollers",
                        "https://www.coursera.org/search?query=microcontrollers");
                added++;
            }

            if (!iot && added < 6) {
                course(result,
                        "IoT",
                        "IoT",
                        "https://www.coursera.org/search?query=internet%20of%20things");
                added++;
            }

        } else if (role.equals("IoT Engineer")) {

            if (!iot && added < 6) {
                course(result,
                        "IoT",
                        "IoT",
                        "https://www.coursera.org/search?query=internet%20of%20things");
                added++;
            }

            if (!embedded && added < 6) {
                course(result,
                        "Embedded Systems",
                        "Embedded Systems",
                        "https://www.coursera.org/search?query=embedded%20systems");
                added++;
            }

            if (!microcontroller && added < 6) {
                course(result,
                        "Microcontrollers",
                        "Microcontrollers",
                        "https://www.coursera.org/search?query=microcontrollers");
                added++;
            }

        } else if (role.equals(
                "PCB Design Engineer")) {

            if (!pcb && added < 6) {
                course(result,
                        "PCB Design",
                        "PCB",
                        "https://www.kicad.org/docs/");
                added++;
            }

            if (!kicad && added < 6) {
                course(result,
                        "KiCad",
                        "PCB Design",
                        "https://www.kicad.org/docs/");
                added++;
            }

        } else {

            if (!dsa && added < 6) {
                course(result,
                        "Data Structures",
                        "DSA",
                        "https://www.geeksforgeeks.org/data-structures/");
                added++;
            }

            if (!sql && added < 6) {
                course(result,
                        "SQL",
                        "SQL",
                        "https://www.w3schools.com/sql/");
                added++;
            }

            if (!git && added < 6) {
                course(result,
                        "Git",
                        "Git",
                        "https://git-scm.com/doc");
                added++;
            }

            if (!python && added < 6) {
                course(result,
                        "Python",
                        "Python",
                        "https://docs.python.org/3/tutorial/");
                added++;
            }
        }

        if (added == 0) {

            result.append(
                    "📚 No major learning gap detected.\n"
            );

            result.append(
                    "Focus on advanced projects, interview preparation and specialization.\n"
            );
        }
    }

    // =========================================================
    // COURSE OUTPUT
    // =========================================================

    private void course(
            StringBuilder result,
            String name,
            String skill,
            String link) {

        result.append("📚 ")
              .append(name)
              .append("\n");

        result.append("Skill: ")
              .append(skill)
              .append("\n");

        result.append("Link: ")
              .append(link)
              .append("\n\n");
    }
}