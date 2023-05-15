using System.Collections;
using System.Collections.Generic;
using UnityEditor;
using UnityEngine;
using UnityEngine.SceneManagement;

public class EnviarPlayer : MonoBehaviour
{
    public GameObject player;
    public void enviarPlayer(string nombreNivel)
    {
        PrefabUtility.SaveAsPrefabAsset(player, "Assets/Prefabs");
        SceneManager.LoadScene(nombreNivel);
    }
}
