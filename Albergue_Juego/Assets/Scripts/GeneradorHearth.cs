using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class GeneradorHearth : MonoBehaviour
{
    public GameObject Corazonaprefab;
    public Animator animator;
    public Transform[] generadorPuntos;
    public float VelocidadGeneracion;
    public AudioSource sound;
    void Start()
    {
        animator = GetComponent<Animator>();
        sound = GetComponent<AudioSource>();
    }
    private void OnMouseDown()
    {
        InvokeRepeating("GeneradorCorazones", VelocidadGeneracion, VelocidadGeneracion);
        print("Hiciste un click");

        animator.SetBool("isTouch", true);
        sound.Play();
    }
    private void OnMouseUp()
    {
        CancelInvoke("GeneradorCorazones");
        print("Dejaste de hacer click");

        animator.SetBool("isTouch", false);
    }

    private void GeneradorCorazones()
    {
        Instantiate(Corazonaprefab, generadorPuntos[Random.Range(0, generadorPuntos.Length)].position, Quaternion.identity);
    }
}
