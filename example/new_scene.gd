extends Node2D

# by Thiago Bruno / https://github.com/thiagobruno/GodotCamera

var camera

func _ready():
	# load GodotCamera singleton
	camera = Globals.get_singleton("GodotCamera")
	if camera:
		camera.setCameraCallbackId(get_instance_ID())

func _on_Button_pressed():
	if camera:
		# reset TextureFrame
		get_node("AnimationPlayer/icon").set_texture(null)

		# open native preview camera
		camera.openCamera()

func _on_GodotCamera_success(_fileName):
	# photo taken
	get_node("AnimationPlayer/icon").set_texture(ResourceLoader.load(_fileName))
