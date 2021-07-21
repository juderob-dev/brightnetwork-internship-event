package com.google;

import java.util.*;

public class VideoPlayer {

  private final VideoLibrary videoLibrary;
  private Video videoPlaying;
  private String state;
  private List<VideoPlaylist> playLists;



  public VideoPlayer() {
    this.videoLibrary = new VideoLibrary();
    this.videoPlaying=null;
    this.playLists=new ArrayList<VideoPlaylist>();
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

    Random rand= new Random();
    Video[] arr=new Video[this.videoLibrary.getVideos().size()];
    arr= this.videoLibrary.getVideos().toArray(arr);
    Video randomValue=arr[rand.nextInt(arr.length)];
    String temp=randomValue.getVideoId();
    this.playVideo(temp);




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
    VideoPlaylist playlistNow= new VideoPlaylist(playlistName);
    if(!(playLists.size()<1)){
      for( VideoPlaylist playlist:playLists){
        if(playlistNow.equals(playlist)){
          System.out.println("Cannot create playlist: playlist with the same name already exists");
          break;
        }

      }
      playLists.add(playlistNow);
      System.out.println("Successfully created new playlist: "+playlistName);
    }
    else{
      playLists.add(playlistNow);
      System.out.println("Successfully created new playlist: "+playlistName);
    }


  }

  public void addVideoToPlaylist(String playlistName, String videoId) {
    VideoPlaylist playlistNow= new VideoPlaylist(playlistName);
    try{
      Video video=videoLibrary.getVideo(videoId);

    }
    catch(Exception e){
      System.out.println("Cannot add video to playlist: video does not exist");

    }



    if(!(playLists.size()<1)){
      for( VideoPlaylist playlist:playLists){
        if(playlistNow.equals(playlist)){
          playlistNow.addVideo(video);
          System.out.println("Cannot create playlist: playlist with the same name already exists");
          break;
        }

      }
      playLists.add(playlistNow);
      playlistNow.addVideo(video);
      System.out.println("Successfully created new playlist: "+playlistName);
    }
    else{
      playLists.add(playlistNow);
      playlistNow.addVideo(video);
      System.out.println("Successfully created new playlist: "+playlistName);
    }


    System.out.println("addVideoToPlaylist needs implementation");
  }

  public void showAllPlaylists() {
    if (!(this.playLists.isEmpty())){
      System.out.println("Showing all Playlist ");
      for(VideoPlaylist playlist:playLists){
        String temp=playlist.getName();
        System.out.println(temp);

      }
    }

    System.out.println("No playlist exist yet");
  }
  public VideoPlaylist findPlaylist(String playlistName){
    for(VideoPlaylist playlist:playLists){
      if (playlist.getName().toLowerCase(Locale.ROOT).equals(playlistName.toLowerCase(Locale.ROOT))){
        return playlist;
      }
    }
    return null;


  }

  public void showPlaylist(String playlistName) {
    if(playLists.isEmpty()){
      if (this.findPlaylist(playlistName)!=null){
        System.out.println("Showing playlist:"+playlistName);
        VideoPlaylist temp=this.findPlaylist(playlistName);
        temp.showVideos();
      }
      else{
        System.out.println("Cannot show playlist");

      }

    }
    System.out.println("showPlaylist needs implementation");
    else{
      System.out.println("No playlist exist yet");

    }
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