package com.Amano.excalibur.entity.renderer;

import com.Amano.excalibur.entity.model.CustomEntityModel;
import com.Amano.excalibur.main.Excalibur;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;

public class CustomEntityRenderer extends EntityRenderer {
    private CustomEntityModel customEntityModel;

    public CustomEntityRenderer(EntityRendererProvider.Context pContext) {
        super(pContext);

        customEntityModel = new CustomEntityModel(pContext.bakeLayer(CustomEntityModel.LAYER_LOCATION));
    }

    @Override
    public ResourceLocation getTextureLocation(Entity pEntity) {
        return new ResourceLocation(Excalibur.MODID, "textures/entity/custom_entity.png");
    }

    @Override
    public void render(Entity pEntity, float pEntityYaw, float pPartialTick, PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight) {
        super.render(pEntity, pEntityYaw, pPartialTick, pPoseStack, pBuffer, pPackedLight);

        pPoseStack.pushPose();

        pPoseStack.mulPose(Axis.YN.rotationDegrees(0));

        pPoseStack.translate(0,0,0);

        VertexConsumer buffer = pBuffer.getBuffer(this.customEntityModel.renderType(this.getTextureLocation(pEntity)));

        this.customEntityModel.renderToBuffer(pPoseStack,buffer,pPackedLight, OverlayTexture.NO_OVERLAY,1f,1f,1f,1f);
        pPoseStack.popPose();
    }

}
