package com.google;

import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Queue;

/** A class used to represent a Playlist */
class VideoPlaylist {
    private String name;
    private Queue<Video> videos;


    public VideoPlaylist(String name){
        this.name=name;
        this.videos=new LinkedList<>();
        
    }
    public boolean equals(Object object ){
        boolean sameSame = false;

        if (object != null && object instanceof VideoPlaylist)
        {
            sameSame = this.name.toLowerCase(Locale.ROOT).equals(((VideoPlaylist) object).name.toLowerCase(Locale.ROOT));
        }

        return sameSame;

    }
    public void addVideo(Video video){
        if(videos.contains(video)){this.videos.add(video);}
        else{
            System.out.println("Cannot add video to"+this.name+":video already added");
        }

    }
   public String getName(){
        return (this.name);
    }
    public void showVideos(){
        if(!(videos.isEmpty())){
            for(Video video:videos){
                String temp= video.showContent();
                System.out.println(temp);
            }
        }
        else{
            System.out.println("No videos here yet");

        }


    }
}
