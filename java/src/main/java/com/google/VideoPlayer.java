package com.google;

import java.util.ArrayList;
import java.util.List;

public class VideoPlayer {

  private final VideoLibrary videoLibrary;
  private Video videoPlaying;
  private String state;

  public VideoPlayer() {
    this.videoLibrary = new VideoLibrary();
    this.videoPlaying=null;
  }

  public void numberOfVideos() {
    System.out.printf("%s videos in the library%n", videoLibrary.getVideos().size());
  }

  public void showAllVideos() {
    System.out.println("here is a list of all available videos:");
    List<Video> videos= new ArrayList<>(videoLibrary.getVideos());
    for(Video video:videos){
      System.out.println(video.getTitle()+" ("+video.getVideoId()+") "+video.stringTags());
    }
  }

  public void playVideo(String videoId) {
    if (videoPlaying!=null){
      System.out.println("Stopping video: "+this.videoPlaying.getTitle());
      System.out.println("Playing video: "+videoLibrary.getVideo(videoId));

    }
    else{
      System.out.println("Playing video: "+videoLibrary.getVideo(videoId));
    }
    this.videoPlaying=videoLibrary.getVideo(videoId);
    this.state="playing";



  }

  public void stopVideo() {
    if(videoPlaying==null){
      System.out.println("Cannot stop video: No video is currently playing ");

    }
    else{
      System.out.println("Stopping video: "+this.videoPlaying.getTitle());}
    this.videoPlaying=null;
    this.state="";
  }

  public void playRandomVideo() {
    System.out.println("playRandomVideo needs implementation");
  }

  public void pauseVideo() {
    if(this.state.equals("playing") && this.videoPlaying!=null ){
      this.state="pause";
      System.out.println("Pausing video: "+this.videoPlaying.getTitle());}

    else if(this.videoPlaying!=null && this.state.equals("pause")){
      System.out.println("Video is already paused:"+this.videoPlaying.getTitle());

    }
    else{
    System.out.println("Cannot pause video: No video is currently playing");
    }

  }

  public void continueVideo() {
    if(this.state.equals("playing") && this.videoPlaying!=null ){

      System.out.println("Cannot continue video: video is not paused");}

    else if(this.videoPlaying!=null && this.state.equals("pause")){
      state="playing";
      System.out.println("Continuing video: "+this.videoPlaying.getTitle());

    }
    else{
      System.out.println("Cannot continue video: No video is currently playing");
    }
  }

  public void showPlaying() {
    if (this.videoPlaying!=null && state=="playing"){
      System.out.println("Currently playing:"+videoPlaying.getTitle()+" ("+videoPlaying.getVideoId()+") "+videoPlaying.stringTags());

    }
    else if(this.videoPlaying!=null && state=="pause"){
      System.out.println("Currently playing:"+videoPlaying.getTitle()+" ("+videoPlaying.getVideoId()+") "+videoPlaying.stringTags()+ " - PAUSED");

    }
    else{
      System.out.println("No video is currently playing");

    }

  }

  public void createPlaylist(String playlistName) {
    System.out.println("createPlaylist needs implementation");
  }

  public void addVideoToPlaylist(String playlistName, String videoId) {
    System.out.println("addVideoToPlaylist needs implementation");
  }

  public void showAllPlaylists() {
    System.out.println("showAllPlaylists needs implementation");
  }

  public void showPlaylist(String playlistName) {
    System.out.println("showPlaylist needs implementation");
  }

  public void removeFromPlaylist(String playlistName, String videoId) {
    System.out.println("removeFromPlaylist needs implementation");
  }

  public void clearPlaylist(String playlistName) {
    System.out.println("clearPlaylist needs implementation");
  }

  public void deletePlaylist(String playlistName) {
    System.out.println("deletePlaylist needs implementation");
  }

  public void searchVideos(String searchTerm) {
    System.out.println("searchVideos needs implementation");
  }

  public void searchVideosWithTag(String videoTag) {
    System.out.println("searchVideosWithTag needs implementation");
  }

  public void flagVideo(String videoId) {
    System.out.println("flagVideo needs implementation");
  }

  public void flagVideo(String videoId, String reason) {
    System.out.println("flagVideo needs implementation");
  }

  public void allowVideo(String videoId) {
    System.out.println("allowVideo needs implementation");
  }
}