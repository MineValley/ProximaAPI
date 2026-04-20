package eu.minevalley.proxima.api.database;

import lombok.Getter;
import redis.clients.jedis.JedisPooled;

import javax.annotation.Nonnull;

@SuppressWarnings("unused")
public final class Redis {

    @Getter(onMethod_ = {@Nonnull})
    private static JedisPooled commandPool;

    @Getter(onMethod_ = {@Nonnull})
    private static JedisPooled subPool;

    @Getter(onMethod_ = {@Nonnull})
    private static JedisPooled pubPool;
}