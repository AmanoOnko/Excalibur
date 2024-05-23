package com.Amano.excalibur.entity.model;// Made with Blockbench 4.10.1
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;

public class CustomEntityModel<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("modid", "customentitymodel"), "main");
	private final ModelPart bb_main;

	public CustomEntityModel(ModelPart root) {
		this.bb_main = root.getChild("bb_main");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition bb_main = partdefinition.addOrReplaceChild("bb_main", CubeListBuilder.create().texOffs(397, 255).addBox(-16.0F, -32.0F, -15.0F, 32.0F, 32.0F, 22.0F, new CubeDeformation(0.0F))
		.texOffs(352, 164).addBox(-18.0F, -34.0F, -11.0F, 36.0F, 36.0F, 20.0F, new CubeDeformation(0.0F))
		.texOffs(276, 0).addBox(18.0F, -36.0F, -7.0F, 2.0F, 38.0F, 30.0F, new CubeDeformation(0.0F))
		.texOffs(410, 0).addBox(-14.0F, -30.0F, -18.0F, 28.0F, 28.0F, 23.0F, new CubeDeformation(0.0F))
		.texOffs(503, 11).addBox(20.0F, 1.0F, -1.0F, 2.0F, 2.0F, 40.0F, new CubeDeformation(0.0F))
		.texOffs(116, 408).addBox(20.0F, -1.0F, -2.0F, 2.0F, 2.0F, 50.0F, new CubeDeformation(0.0F))
		.texOffs(421, 177).addBox(20.0F, -3.0F, -4.0F, 2.0F, 2.0F, 43.0F, new CubeDeformation(0.0F))
		.texOffs(48, 494).addBox(20.0F, -7.0F, -5.0F, 2.0F, 4.0F, 40.0F, new CubeDeformation(0.0F))
		.texOffs(356, 461).addBox(20.0F, -9.0F, -3.0F, 2.0F, 2.0F, 42.0F, new CubeDeformation(0.0F))
		.texOffs(352, 73).addBox(20.0F, -12.0F, 0.0F, 2.0F, 3.0F, 54.0F, new CubeDeformation(0.0F))
		.texOffs(108, 460).addBox(20.0F, -14.0F, -2.0F, 2.0F, 2.0F, 42.0F, new CubeDeformation(0.0F))
		.texOffs(0, 460).addBox(20.0F, -16.0F, 0.0F, 2.0F, 2.0F, 42.0F, new CubeDeformation(0.0F))
		.texOffs(502, 319).addBox(20.0F, -18.0F, -1.0F, 2.0F, 2.0F, 40.0F, new CubeDeformation(0.0F))
		.texOffs(0, 408).addBox(20.0F, -20.0F, -2.0F, 2.0F, 2.0F, 50.0F, new CubeDeformation(0.0F))
		.texOffs(421, 102).addBox(20.0F, -22.0F, -4.0F, 2.0F, 2.0F, 43.0F, new CubeDeformation(0.0F))
		.texOffs(488, 452).addBox(20.0F, -26.0F, -5.0F, 2.0F, 4.0F, 40.0F, new CubeDeformation(0.0F))
		.texOffs(458, 364).addBox(20.0F, -28.0F, -3.0F, 2.0F, 2.0F, 42.0F, new CubeDeformation(0.0F))
		.texOffs(310, 458).addBox(20.0F, -33.0F, -2.0F, 2.0F, 2.0F, 42.0F, new CubeDeformation(0.0F))
		.texOffs(457, 51).addBox(20.0F, -35.0F, 0.0F, 2.0F, 2.0F, 42.0F, new CubeDeformation(0.0F))
		.texOffs(352, 0).addBox(20.0F, -31.0F, 0.0F, 2.0F, 3.0F, 54.0F, new CubeDeformation(0.0F))
		.texOffs(200, 494).addBox(-22.0F, -18.0F, -1.0F, 2.0F, 2.0F, 40.0F, new CubeDeformation(0.0F))
		.texOffs(62, 398).addBox(-22.0F, -20.0F, -2.0F, 2.0F, 2.0F, 50.0F, new CubeDeformation(0.0F))
		.texOffs(79, 273).addBox(-22.0F, -22.0F, -4.0F, 2.0F, 2.0F, 43.0F, new CubeDeformation(0.0F))
		.texOffs(156, 464).addBox(-22.0F, -26.0F, -5.0F, 2.0F, 4.0F, 40.0F, new CubeDeformation(0.0F))
		.texOffs(92, 94).addBox(-22.0F, -28.0F, -3.0F, 2.0F, 2.0F, 42.0F, new CubeDeformation(0.0F))
		.texOffs(92, 44).addBox(-22.0F, -33.0F, -2.0F, 2.0F, 2.0F, 42.0F, new CubeDeformation(0.0F))
		.texOffs(92, 0).addBox(-22.0F, -35.0F, 0.0F, 2.0F, 2.0F, 42.0F, new CubeDeformation(0.0F))
		.texOffs(100, 341).addBox(-22.0F, -31.0F, 0.0F, 2.0F, 3.0F, 54.0F, new CubeDeformation(0.0F))
		.texOffs(483, 235).addBox(-22.0F, 1.0F, -1.0F, 2.0F, 2.0F, 40.0F, new CubeDeformation(0.0F))
		.texOffs(216, 353).addBox(-22.0F, -1.0F, -2.0F, 2.0F, 2.0F, 50.0F, new CubeDeformation(0.0F))
		.texOffs(171, 185).addBox(-22.0F, -3.0F, -4.0F, 2.0F, 2.0F, 43.0F, new CubeDeformation(0.0F))
		.texOffs(444, 463).addBox(-22.0F, -7.0F, -5.0F, 2.0F, 4.0F, 40.0F, new CubeDeformation(0.0F))
		.texOffs(0, 91).addBox(-22.0F, -9.0F, -3.0F, 2.0F, 2.0F, 42.0F, new CubeDeformation(0.0F))
		.texOffs(0, 44).addBox(-22.0F, -14.0F, -2.0F, 2.0F, 2.0F, 42.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-22.0F, -16.0F, 0.0F, 2.0F, 2.0F, 42.0F, new CubeDeformation(0.0F))
		.texOffs(339, 255).addBox(-22.0F, -12.0F, 0.0F, 2.0F, 3.0F, 54.0F, new CubeDeformation(0.0F))
		.texOffs(92, 138).addBox(-18.0F, -34.0F, 11.0F, 36.0F, 36.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(276, 182).addBox(-22.0F, -38.0F, -1.0F, 3.0F, 3.0F, 70.0F, new CubeDeformation(0.0F))
		.texOffs(276, 91).addBox(19.0F, -38.0F, -1.0F, 3.0F, 3.0F, 70.0F, new CubeDeformation(0.0F))
		.texOffs(276, 0).addBox(19.0F, 3.0F, -1.0F, 3.0F, 3.0F, 70.0F, new CubeDeformation(0.0F))
		.texOffs(263, 273).addBox(-22.0F, 3.0F, -1.0F, 3.0F, 3.0F, 70.0F, new CubeDeformation(0.0F))
		.texOffs(184, 182).addBox(22.0F, -16.0F, 11.0F, 2.0F, 3.0F, 88.0F, new CubeDeformation(0.0F))
		.texOffs(184, 273).addBox(22.0F, -19.0F, 6.0F, 2.0F, 3.0F, 75.0F, new CubeDeformation(0.0F))
		.texOffs(184, 91).addBox(22.0F, -22.0F, 14.0F, 2.0F, 3.0F, 88.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition cube_r1 = bb_main.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(92, 185).addBox(-1.0F, -3.0F, -1.0F, 2.0F, 3.0F, 75.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 7.0F, 7.0F, 0.0F, 0.0F, 1.5708F));

		PartDefinition cube_r2 = bb_main.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 3.0F, 88.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, 7.0F, 15.0F, 0.0F, 0.0F, 1.5708F));

		PartDefinition cube_r3 = bb_main.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(0, 91).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 3.0F, 88.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, 7.0F, 12.0F, 0.0F, 0.0F, 1.5708F));

		PartDefinition cube_r4 = bb_main.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(105, 263).addBox(-1.0F, -3.0F, -1.0F, 2.0F, 3.0F, 75.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, -39.0F, 7.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r5 = bb_main.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(92, 3).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 3.0F, 88.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, -39.0F, 15.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r6 = bb_main.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(92, 94).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 3.0F, 88.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0F, -39.0F, 12.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r7 = bb_main.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(0, 273).addBox(-1.0F, -3.0F, -1.0F, 2.0F, 3.0F, 75.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-23.0F, -19.0F, 7.0F, 0.0F, 0.0F, -3.1416F));

		PartDefinition cube_r8 = bb_main.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(0, 182).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 3.0F, 88.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-23.0F, -15.0F, 15.0F, 0.0F, 0.0F, -3.1416F));

		PartDefinition cube_r9 = bb_main.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(184, 0).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 3.0F, 88.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-23.0F, -21.0F, 12.0F, 0.0F, 0.0F, -3.1416F));

		PartDefinition cube_r10 = bb_main.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(284, 346).addBox(-1.0F, -1.0F, -2.0F, 2.0F, 3.0F, 54.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0F, 5.0F, 2.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r11 = bb_main.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(0, 135).addBox(-1.0F, 0.0F, -2.0F, 2.0F, 2.0F, 42.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 5.0F, 2.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r12 = bb_main.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(0, 182).addBox(-1.0F, 0.0F, -2.0F, 2.0F, 2.0F, 42.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, 5.0F, 0.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r13 = bb_main.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(184, 0).addBox(-1.0F, 0.0F, -2.0F, 2.0F, 2.0F, 42.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.0F, 5.0F, -1.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r14 = bb_main.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(468, 95).addBox(-1.0F, -2.0F, -2.0F, 2.0F, 4.0F, 40.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(11.0F, 5.0F, -3.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r15 = bb_main.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(227, 405).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 2.0F, 43.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(15.0F, 5.0F, -3.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r16 = bb_main.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(400, 312).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 2.0F, 50.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(17.0F, 5.0F, -1.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r17 = bb_main.addOrReplaceChild("cube_r17", CubeListBuilder.create().texOffs(488, 496).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 2.0F, 40.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(19.0F, 5.0F, 0.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r18 = bb_main.addOrReplaceChild("cube_r18", CubeListBuilder.create().texOffs(342, 349).addBox(-1.0F, -1.0F, -2.0F, 2.0F, 3.0F, 54.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-14.0F, 5.0F, 2.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r19 = bb_main.addOrReplaceChild("cube_r19", CubeListBuilder.create().texOffs(184, 44).addBox(-1.0F, 0.0F, -2.0F, 2.0F, 2.0F, 42.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-19.0F, 5.0F, 2.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r20 = bb_main.addOrReplaceChild("cube_r20", CubeListBuilder.create().texOffs(184, 94).addBox(-1.0F, 0.0F, -2.0F, 2.0F, 2.0F, 42.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-17.0F, 5.0F, 0.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r21 = bb_main.addOrReplaceChild("cube_r21", CubeListBuilder.create().texOffs(0, 226).addBox(-1.0F, 0.0F, -2.0F, 2.0F, 2.0F, 42.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-12.0F, 5.0F, -1.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r22 = bb_main.addOrReplaceChild("cube_r22", CubeListBuilder.create().texOffs(468, 147).addBox(-1.0F, -2.0F, -2.0F, 2.0F, 4.0F, 40.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.0F, 5.0F, -3.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r23 = bb_main.addOrReplaceChild("cube_r23", CubeListBuilder.create().texOffs(170, 408).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 2.0F, 43.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, 5.0F, -3.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r24 = bb_main.addOrReplaceChild("cube_r24", CubeListBuilder.create().texOffs(270, 403).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 2.0F, 50.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, 5.0F, -1.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r25 = bb_main.addOrReplaceChild("cube_r25", CubeListBuilder.create().texOffs(244, 499).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 2.0F, 40.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 5.0F, 0.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r26 = bb_main.addOrReplaceChild("cube_r26", CubeListBuilder.create().texOffs(0, 351).addBox(-1.0F, -1.0F, -2.0F, 2.0F, 3.0F, 54.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-14.0F, -37.0F, 2.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r27 = bb_main.addOrReplaceChild("cube_r27", CubeListBuilder.create().texOffs(58, 351).addBox(-1.0F, 0.0F, -2.0F, 2.0F, 2.0F, 42.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-19.0F, -37.0F, 2.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r28 = bb_main.addOrReplaceChild("cube_r28", CubeListBuilder.create().texOffs(433, 419).addBox(-1.0F, 0.0F, -2.0F, 2.0F, 2.0F, 42.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-17.0F, -37.0F, 0.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r29 = bb_main.addOrReplaceChild("cube_r29", CubeListBuilder.create().texOffs(62, 450).addBox(-1.0F, 0.0F, -2.0F, 2.0F, 2.0F, 42.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-12.0F, -37.0F, -1.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r30 = bb_main.addOrReplaceChild("cube_r30", CubeListBuilder.create().texOffs(471, 191).addBox(-1.0F, -2.0F, -2.0F, 2.0F, 4.0F, 40.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.0F, -37.0F, -3.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r31 = bb_main.addOrReplaceChild("cube_r31", CubeListBuilder.create().texOffs(410, 57).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 2.0F, 43.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, -37.0F, -3.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r32 = bb_main.addOrReplaceChild("cube_r32", CubeListBuilder.create().texOffs(404, 364).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 2.0F, 50.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, -37.0F, -1.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r33 = bb_main.addOrReplaceChild("cube_r33", CubeListBuilder.create().texOffs(500, 277).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 2.0F, 40.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -37.0F, 0.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r34 = bb_main.addOrReplaceChild("cube_r34", CubeListBuilder.create().texOffs(158, 351).addBox(-1.0F, -1.0F, -2.0F, 2.0F, 3.0F, 54.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0F, -37.0F, 2.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r35 = bb_main.addOrReplaceChild("cube_r35", CubeListBuilder.create().texOffs(218, 450).addBox(-1.0F, 0.0F, -2.0F, 2.0F, 2.0F, 42.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -37.0F, 2.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r36 = bb_main.addOrReplaceChild("cube_r36", CubeListBuilder.create().texOffs(454, 309).addBox(-1.0F, 0.0F, -2.0F, 2.0F, 2.0F, 42.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, -37.0F, 0.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r37 = bb_main.addOrReplaceChild("cube_r37", CubeListBuilder.create().texOffs(264, 455).addBox(-1.0F, 0.0F, -2.0F, 2.0F, 2.0F, 42.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.0F, -37.0F, -1.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r38 = bb_main.addOrReplaceChild("cube_r38", CubeListBuilder.create().texOffs(479, 408).addBox(-1.0F, -2.0F, -2.0F, 2.0F, 4.0F, 40.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(11.0F, -37.0F, -3.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r39 = bb_main.addOrReplaceChild("cube_r39", CubeListBuilder.create().texOffs(385, 416).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 2.0F, 43.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(15.0F, -37.0F, -3.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r40 = bb_main.addOrReplaceChild("cube_r40", CubeListBuilder.create().texOffs(324, 406).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 2.0F, 50.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(17.0F, -37.0F, -1.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r41 = bb_main.addOrReplaceChild("cube_r41", CubeListBuilder.create().texOffs(288, 502).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 2.0F, 40.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(19.0F, -37.0F, 0.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r42 = bb_main.addOrReplaceChild("cube_r42", CubeListBuilder.create().texOffs(92, 185).addBox(-1.0F, -38.0F, -1.0F, 2.0F, 38.0F, 30.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(18.0F, -35.0F, -6.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r43 = bb_main.addOrReplaceChild("cube_r43", CubeListBuilder.create().texOffs(0, 273).addBox(-1.0F, -38.0F, -1.0F, 2.0F, 38.0F, 30.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-19.0F, -34.0F, -6.0F, 0.0F, 0.0F, -3.1416F));

		PartDefinition cube_r44 = bb_main.addOrReplaceChild("cube_r44", CubeListBuilder.create().texOffs(263, 273).addBox(-1.0F, -38.0F, -1.0F, 2.0F, 38.0F, 30.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(20.0F, 3.0F, -6.0F, 0.0F, 0.0F, -1.5708F));

		return LayerDefinition.create(meshdefinition, 1024, 1024);
	}

	@Override
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		bb_main.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}