import java.util.HashMap;
import java.util.Map;

public enum EnvTagEnum {

    CN_AE_ONLINE_ENV("AE线上","cn_ae_online_env","AE","publish"),
    CN_LZD_ONLINE_ENV("LZD线上","cn_lzd_online_env","LZD","publish"),
    CN_TMI_ONLINE_ENV("TMI线上","cn_tmi_online_env","TMI","publish"),
    CN_IM_ONLINE_ENV("IM线上","cn_im_online_env","IM","publish"),
    CN_B2B_ONLINE_ENV("B2B线上","cn_b2b_online_env","B2B","publish"),
    CN_GRAY4_ONLINE_ENV("GRAY4线上","gray4","ALL","publish"),
    CN_GRAY6_ONLINE_ENV("GRAY6线上"," gray6-cn","ALL","publish"),

    CN_AE_TEST_ENV("AE预发","CN_AE_TEST_ENV","AE","prepub"),
    CN_TMI_TEST_ENV("TMI预发","CN_TMI_TEST_ENV","TMI","prepub"),
    CN_LZD_TEST_ENV("LZD预发","CN_LZD_TEST_ENV","LZD","prepub"),
    CN_IM_TEST_ENV("IM预发","CN_IM_TEST_ENV","IM","prepub");


    private String name;
    private String code;
    private String channel;
    private String env;

    private static final Map<String ,Map<String,EnvTagEnum>> ENV_TO_CHANNEL_TO_ENVTAGENUM_MAP = new HashMap<>();

    private static final Map<String ,Map<String,EnvTagEnum>> ENV_TO_CODE_TO_ENVTAGENUM_MAP = new HashMap<>();

    static{
        for(EnvTagEnum envTagEnum :EnvTagEnum.values()){
            if(ENV_TO_CHANNEL_TO_ENVTAGENUM_MAP.get(envTagEnum.getEnv()) == null){
                ENV_TO_CHANNEL_TO_ENVTAGENUM_MAP.put(envTagEnum.getEnv(),new HashMap<>());
            }
            ENV_TO_CHANNEL_TO_ENVTAGENUM_MAP.get(envTagEnum.getEnv()).put(envTagEnum.getChannel(),envTagEnum);

            if(ENV_TO_CODE_TO_ENVTAGENUM_MAP.get(envTagEnum.getEnv()) == null){
                ENV_TO_CODE_TO_ENVTAGENUM_MAP.put(envTagEnum.getEnv(),new HashMap<>());
            }
            ENV_TO_CODE_TO_ENVTAGENUM_MAP.get(envTagEnum.getEnv()).put(envTagEnum.getCode(), envTagEnum);
        }
    }

    public static EnvTagEnum getEnvTagByChannel(String env,String bizChannel){
        return ENV_TO_CHANNEL_TO_ENVTAGENUM_MAP.getOrDefault(env,new HashMap<>()).get(bizChannel);
    }

    public static EnvTagEnum getEnvTagByCode(String env,String code){
        return ENV_TO_CODE_TO_ENVTAGENUM_MAP.getOrDefault(env,new HashMap<>()).get(code);
    }

    private EnvTagEnum(String name,String code,String channel,String env){
        this.name = name;
        this.code = code;
        this.channel = channel;
        this.env = env;
    }

    public String getName(){
        return name;
    }
    public String getCode(){
        return code;
    }
    public String getChannel(){
        return channel;
    }
    public String getEnv(){
        return env;
    }
}
