package net.lyivx.ls_furniture.common.utils;


public interface IPlatformHelper {
    Platform getPlatform();

    boolean isModLoaded(String paramString);

    boolean isDevelopmentEnvironment();

    default String getEnvironmentName() {
        return isDevelopmentEnvironment() ? "development" : "production";
    }

    public enum Platform {
        FORGE, FABRIC;

        public boolean isForge() {
            return (this == FORGE);
        }

        public boolean isFabric() {
            return (this == FABRIC);
        }
    }
}
