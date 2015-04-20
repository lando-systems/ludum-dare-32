package lando.systems.ld32;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.*;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import lando.systems.ld32.effects.Explode;
import lando.systems.ld32.effects.Puff;
import lando.systems.ld32.effects.StunStars;
import lando.systems.ld32.effects.Xout;

public class Assets {

    public static SpriteBatch   batch;
    public static ShapeRenderer shapes;

    public static BitmapFont font8;
    public static BitmapFont font16;
    public static BitmapFont font32;

    public static ShaderProgram postShader;

    public static Texture background1;
    public static Texture killphraseBox;
    public static Texture speechBubbleTexture;
    public static Texture enemyTexture;
    public static Texture effectsTexture;
    public static Texture stunStarsTexture;
    public static TextureRegion[][] enemyRegions;
    public static TextureRegion[][] effectsRegions;
    public static TextureRegion[][] stunStarsRegions;
    public static NinePatch speechBubble;

    public static Animation puffAnimation;
    public static Animation stunStarsAnimation;
    public static Animation explodeAnimation;
    public static Animation xoutAnimation;

    public static Animation defaultEnemyAnimation;
    public static Animation defaultEnemyAnimation2;

    public static void load() {
        batch = new SpriteBatch();
        shapes = new ShapeRenderer();

        font8 = new BitmapFont(Gdx.files.internal("fonts/monaco8.fnt"));
        font8.setMarkupEnabled(true);
        font16 = new BitmapFont(Gdx.files.internal("fonts/monaco16.fnt"));
        font16.setMarkupEnabled(true);
        font32 = new BitmapFont(Gdx.files.internal("fonts/monaco32.fnt"));
        font32.setMarkupEnabled(true);

        postShader = new ShaderProgram(
                Gdx.files.internal("shaders/default.vert"),
                Gdx.files.internal("shaders/post.frag"));

        background1 = new Texture("background1.png");
        killphraseBox = new Texture("killphrase-box.png");
        speechBubbleTexture = new Texture("speech-bubble.png");
        enemyTexture = new Texture("oryx_16bit_scifi_creatures_extra_trans.png");
        effectsTexture = new Texture("oryx_16bit_scifi_FX_lg_trans.png");
        stunStarsTexture = new Texture("stun-stars.png");
        enemyRegions = TextureRegion.split(enemyTexture, 24, 24);
        effectsRegions = TextureRegion.split(effectsTexture, 32, 32);
        stunStarsRegions = TextureRegion.split(stunStarsTexture, 24, 16);
        speechBubble = new NinePatch(speechBubbleTexture, 5, 5, 5, 5);

        // Animations
        puffAnimation = new Animation(
            Puff.puff_time,
            effectsRegions[2][3],
            effectsRegions[2][4],
            effectsRegions[10][4],
            effectsRegions[10][5],
            effectsRegions[10][6],
            effectsRegions[10][7]);
        stunStarsAnimation = new Animation(
            StunStars.stunstars_time,
            stunStarsRegions[0][0],
            stunStarsRegions[0][1],
            stunStarsRegions[0][2]);
        stunStarsAnimation.setPlayMode(Animation.PlayMode.LOOP);
        explodeAnimation = new Animation(
            Explode.explode_time,
            effectsRegions[0][0],
            effectsRegions[0][1],
            effectsRegions[10][0],
            effectsRegions[10][1]);
        xoutAnimation = new Animation(
            Xout.xout_time,
            effectsRegions[1][2],
            effectsRegions[1][3]);



        // TODO: Temporary animations
        defaultEnemyAnimation = new Animation(
            .3f,
            new TextureRegion(enemyRegions[0][0]),
            new TextureRegion(enemyRegions[1][0]));
        defaultEnemyAnimation.setPlayMode(Animation.PlayMode.LOOP);
        defaultEnemyAnimation2 = new Animation(
                .3f,
                new TextureRegion(enemyRegions[2][0]),
                new TextureRegion(enemyRegions[3][0]));
        defaultEnemyAnimation2.setPlayMode(Animation.PlayMode.LOOP);
    }

    public static void dispose() {
        batch.dispose();
        shapes.dispose();
        background1.dispose();
        killphraseBox.dispose();
        speechBubbleTexture.dispose();
        enemyTexture.dispose();
        effectsTexture.dispose();
        postShader.dispose();
        font32.dispose();
        font16.dispose();
        font8.dispose();
    }

}
