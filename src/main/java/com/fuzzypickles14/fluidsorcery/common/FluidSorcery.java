package com.fuzzypickles14.fluidsorcery.common;

import com.fuzzypickles14.fluidsorcery.common.core.proxy.CommonProxy;
import com.fuzzypickles14.fluidsorcery.common.lib.LibModDetails;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = LibModDetails.MOD_ID, version = LibModDetails.MOD_VERSION, name = LibModDetails.MOD_NAME)
public class FluidSorcery
{

    @Mod.Instance(LibModDetails.MOD_ID)
    public static FluidSorcery instance;

    @SidedProxy(clientSide = LibModDetails.CLIENT_PROXY, serverSide = LibModDetails.COMMON_PROXY)
    public static CommonProxy proxy;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        proxy.preInit(event);
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        proxy.init(event);

    }

    static
    {
        FluidRegistry.enableUniversalBucket();
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        proxy.postInit(event);
    }
}
