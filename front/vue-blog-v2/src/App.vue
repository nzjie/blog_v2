<template>
  <router-view />
</template>

<script>

export default {
  name: 'App',
}
</script>

<style>
* {
  margin: 0;
  padding: 0;
  -webkit-tap-highlight-color: transparent;
  -webkit-touch-callout: none;
}

body {
  ont-family: "Helvetica Neue", Helvetica, Arial, sans-serif;
  font-size: 14px;
  line-height: 1.42857143;
  color: #3D3D3D;
}

a {
  text-decoration: none;
}

.floatR {
  float: right;
}

.flex {
  display: flex;
}

input, textarea, select, a:focus {
  outline: none;
}

.color-gre {
  color: #3399ea;
}

.hidden {
  display: none
}

.hiddenforce {
  display: none !important;
}

/* 富文本编辑器java代码部分样式 */
.language-java {
  display: inline-block;
  min-width: calc(100% - 30px);
  min-width: -webkit-calc(100% - 30px);
  background: #333;
  color: #fff;
  margin: 10px 0;
  padding: 15px;
}

/*
	z-index说明：
		侧栏滑出窗体[1000-1499]
		弹窗在[1500-1999]
		悬浮菜单也算弹窗，所以要在1500-1999
		loading:[2000-2500];
		success:[2500-3000];
		toast:[3000-3500];
		共用的取高着，如loading和toast共用show_msg-dialog,则去toast的范围

*/

/*禁止弹窗滚动时后面的页面也滚动*/
.disable-scroll {
  overflow: hidden
}

/*弹窗相关*/
.window-plugin-background {
  z-index: 1500;
  position: fixed;
  top: 0;
  left: 0;
  bottom: 0;
  right: 0;
  width: 100%;
  height: 100%;
  background: #000000;
  opacity: .3;
  filter: alpha(opacity=30); /*IE浏览器*/;
  display: none;
}

.modal-background-show {
  animation: modal_background_show .2s ease-in-out;
}

.window-plugin-dialog {
  position: fixed;
  z-index: 1501;
  display: none;
  background-color: #ffffff;
  overflow: scroll;
}

.window-plugin-closer {
  position: absolute;
  width: 36px;
  height: 36px;
  top: 15px;
  right: 15px;
  cursor: pointer;
  background-image: url('http://www.ajie18.top/images/closer.png');
  background-position: center center;
  background-repeat: no-repeat;
}

/*弹窗结束*/

/**交互*/
/*toast和loading*/
.show-msg-modal {
  background-color: rgba(255, 255, 255, 0);
  position: fixed;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
}

.show-msg-dialog {
  z-index: 3000;
  position: fixed;
  max-width: 200px;
  max-height: 200px;
  border-radius: 5px;
  background: #000;
  background-color: rgba(0, 0, 0, 0.7);
}

.content-text {
  color: #fff;
  padding: 10px 20px;
  word-wrap: break-word;
}

.show-msg-loading-icon {
  width: 100%;
  position: absolute;
  text-align: center;
}

.show-msg-loading-icon > .loading-item {
  animation: loading-fade 1s linear infinite;
  -webkit-animation: loading-fade 1s linear infinite;
  width: 2px;
  height: 25px;
  background: #fff;
  display: inline-block;
  position: absolute
}

.content-text-icon {
  bottom: 15px;
  position: absolute;
  padding: 0 10px;
  width: calc(100% - 20px);
  -webkit-width: calc(100% - 20px);
  text-align: center;
  color: #fff;
  overflow: hidden;
  text-overflow: ellipsis;
  white-space: nowrap;
}

.show-msg-loading-content {
  width: 100%;
  position: absolute;
}

/**侧边滑出窗口*/
.slide-win-mask {
  position: fixed;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background-color: rgb(0, 0, 0);
  display: none;
  z-index: 1000
}

.slide-win-dialog {
  transition: transform .3s ease-in-out;
  position: fixed;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background: #fff;
  z-index: 1001;
  overflow-y: scroll;
  -webkit-overflow-scrolling: touch;
}

.slide-win-dialog:after {
  min-height: calc(100% + 1px)
}

/*动画*/
.modal-dialog-show {
  animation: modal_dialog_show .2s linear;
}

.modal-background-hide {
  animation: modal_background_hide .2s ease-in-out;
  animation-fill-mode: both;
}

.modal-dialog-hide {
  animation: modal_dialog_hide .2s ease-in-out;
  animation-fill-mode: both;
}

.slide-win-mask-show {
  animation: slide_win_mask_show .3s linear;
  animation-fill-mode: both;
}

.slide-win-mask-hide {
  animation: slide_win_mask_hide .3s linear;
  animation-fill-mode: both;
}

@keyframes modal_dialog_show {
  0% {
    transform: scale(.5, .5);
    opacity: 0;
  }
  100% {
    transform: scale(1, 1);
    opacity: 1
  }
}

@keyframes modal_background_show {
  0% {
    opacity: 0;
  }
  100% {
    opacity: .3
  }
}

@keyframes modal_dialog_hide {
  0% {
    transform: scale(1, 1);
    opacity: 1;
  }
  100% {
    transform: scale(.5, .5);
    opacity: 0
  }
}

@keyframes modal_background_hide {
  0% {
    opacity: .3;
  }
  100% {
    opacity: 0
  }
}

@-webkit-keyframes loading-fade {
  from {
    opacity: 1;
  }
  to {
    opacity: 0.25;
  }
}

@keyframes loading-fade {
  from {
    opacity: 1;
  }
  to {
    opacity: 0.25;
  }

}

@keyframes slide_win_mask_show {
  from {
    opacity: 0;
  }
  to {
    opacity: 1;
  }
}

@keyframes slide_win_mask_hide {
  from {
    opacity: 1;
  }
  to {
    opacity: 0;
  }
}

/*到底提示*/
.footer-dv {
  display: flex;
  white-space: nowrap;
  padding-bottom: 15px;
}

.footer-content {
  padding: 0 15px;
  color: #888
}

.footer-line {
  position: relative;
  width: 100%;
}

.footer-line:after {
  content: '';
  position: absolute;
  width: 75%;
  height: 1px;
  background: #888;
  top: 50%;
  right: 0;
  transform: scaleY(0.5);
}

.after-left:after {
  left: 0;
}

[v-cloak] {
  display: none;
}

</style>
